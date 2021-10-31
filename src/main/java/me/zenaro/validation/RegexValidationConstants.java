package me.zenaro.validation;

import static java.lang.String.format;

public final class RegexValidationConstants {

    private RegexValidationConstants() {
    }

    private static final String CAPITAL_LETTER = "A-Z";
    private static final String DIGITS = "0-9";
    private static final String LOWER_CASE = "a-z";
    private static final String SPECIAL_CHARACTERES = "!@#$%^&*()-+";

    private static final String REGEX_GROUP = "[%s]";
    private static final String REGEX_NEGATE_GROUP = format(REGEX_GROUP, "^%s");

    public static final String CAPITAL_LETTER_REGEX = format(REGEX_GROUP, CAPITAL_LETTER);
    public static final String DIGITS_REGEX = format(REGEX_GROUP, DIGITS);
    public static final String LOWER_CASE_REGEX = format(REGEX_GROUP, LOWER_CASE);
    public static final String SPECIAL_CHARACTERES_REGEX = format(REGEX_GROUP, SPECIAL_CHARACTERES);
    public static final String INVALID_CHARACTERES_REGEX = format(REGEX_NEGATE_GROUP,
            String.join(CAPITAL_LETTER, DIGITS, LOWER_CASE, SPECIAL_CHARACTERES));

}
