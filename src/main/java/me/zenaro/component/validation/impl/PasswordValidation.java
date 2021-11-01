package me.zenaro.component.validation.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import me.zenaro.component.validation.ValidationComposite;

@Singleton
public class PasswordValidation extends ValidationComposite<String> {

    @Inject
    public PasswordValidation(final DuplicateCharacterValidation duplicateCharacterValidation,
            final InvalidCharacterValidation invalidCharacterValidation, final MinSizeValidation minSizeValidation,
            final MissingCapitalLetterValidation missingCapitalLetterValidation,
            final MissingDigitsValidation missingDigitsValidation,
            final MissingLowerCaseValidation missingSpecialCharacterValidation,
            final MissingSpecialCharactersValidation missingSpecialCharactersValidation) {
        super(List
                .of(duplicateCharacterValidation, invalidCharacterValidation, minSizeValidation,
                        missingCapitalLetterValidation, missingDigitsValidation, missingSpecialCharacterValidation,
                        missingSpecialCharactersValidation));
    }

}
