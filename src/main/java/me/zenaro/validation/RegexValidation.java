package me.zenaro.validation;

import java.util.regex.Pattern;

public abstract class RegexValidation implements IValidation<String> {

    private final Pattern pattern;

    public RegexValidation(final String regex) {
        this.pattern = Pattern.compile(regex);
    }

    public boolean validate(final String value) {
        return pattern.matcher(value).find();
    }

}
