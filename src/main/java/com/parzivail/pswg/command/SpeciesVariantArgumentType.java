package com.parzivail.pswg.command;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import com.parzivail.pswg.container.SwgSpecies;
import net.minecraft.command.CommandSource;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class SpeciesVariantArgumentType implements ArgumentType<String>
{
	@Override
	public String parse(StringReader reader) throws CommandSyntaxException
	{
		int i = reader.getCursor();

		while (reader.canRead() && isCharValid(reader.peek()))
		{
			reader.skip();
		}

		return reader.getString().substring(i, reader.getCursor());
	}

	private static boolean isCharValid(char c)
	{
		return c >= '0' && c <= '9' || c >= 'a' && c <= 'z' || c == '_' || c == '/' || c == '-';
	}

	@Override
	public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> context, SuggestionsBuilder builder)
	{
		Identifier species = context.getArgument("species", Identifier.class);

		if (!SwgSpecies.SPECIES.contains(species))
		{
			return Suggestions.empty();
		}

		return context.getSource() instanceof CommandSource ? CommandSource.suggestMatching(SwgSpecies.VARIANTS.get(species), builder) : Suggestions.empty();
	}
}
