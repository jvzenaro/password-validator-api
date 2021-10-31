package me.zenaro.validator;

import java.util.regex.Pattern;

public abstract class RegexValidation implements IValidation<String> {

    private final Pattern pattern;

    public RegexValidation(final String charecteresRequiredRegex) {
        this.pattern = Pattern.compile(charecteresRequiredRegex);
    }

    public boolean validate(final String value) {
        return pattern.matcher(value).matches();
    }

}
