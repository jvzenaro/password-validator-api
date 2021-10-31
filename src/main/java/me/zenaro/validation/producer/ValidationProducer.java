package me.zenaro.validation.producer;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import me.zenaro.validation.IValidation;
import me.zenaro.validation.impl.DuplicateCharacterValidation;
import me.zenaro.validation.impl.InvalidCharacterValidation;
import me.zenaro.validation.impl.MaxSizeValidation;
import me.zenaro.validation.impl.MinSizeValidation;
import me.zenaro.validation.impl.MissingCapitalLetterValidation;
import me.zenaro.validation.impl.MissingDigitsValidation;
import me.zenaro.validation.impl.MissingLowerCaseValidation;
import me.zenaro.validation.impl.MissingSpecialCharactersValidation;

@ApplicationScoped
public class ValidationProducer {

    private final DuplicateCharacterValidation duplicateCharacterValidation;
    private final InvalidCharacterValidation invalidCharacterValidation;
    private final MaxSizeValidation maxSizeValidation;
    private final MinSizeValidation minSizeValidation;
    private final MissingCapitalLetterValidation missingCapitalLetterValidation;
    private final MissingDigitsValidation missingDigitsValidation;
    private final MissingLowerCaseValidation missingSpecialCharacterValidation;
    private final MissingSpecialCharactersValidation missingSpecialCharactersValidation;

    public ValidationProducer(DuplicateCharacterValidation duplicateCharacterValidation,
            InvalidCharacterValidation invalidCharacterValidation, MaxSizeValidation maxSizeValidation,
            MinSizeValidation minSizeValidation, MissingCapitalLetterValidation missingCapitalLetterValidation,
            MissingDigitsValidation missingDigitsValidation,
            MissingLowerCaseValidation missingSpecialCharacterValidation,
            MissingSpecialCharactersValidation missingSpecialCharactersValidation) {
        this.duplicateCharacterValidation = duplicateCharacterValidation;
        this.invalidCharacterValidation = invalidCharacterValidation;
        this.maxSizeValidation = maxSizeValidation;
        this.minSizeValidation = minSizeValidation;
        this.missingCapitalLetterValidation = missingCapitalLetterValidation;
        this.missingDigitsValidation = missingDigitsValidation;
        this.missingSpecialCharacterValidation = missingSpecialCharacterValidation;
        this.missingSpecialCharactersValidation = missingSpecialCharactersValidation;
    }

    @Produces
    @Named("passwordValidation")
    List<IValidation<String>> passwordValidation() {
        return List
                .of(duplicateCharacterValidation, invalidCharacterValidation, maxSizeValidation, minSizeValidation,
                        missingCapitalLetterValidation, missingDigitsValidation, missingSpecialCharacterValidation,
                        missingSpecialCharactersValidation);
    }

}
