package ru.kpfu.itis.forms;

import ru.kpfu.itis.exceptions.ValidateException;
import ru.kpfu.itis.models.AbstractModel;
import ru.kpfu.itis.services.I18nService;

import java.util.Locale;

public abstract class AbstractForm extends AbstractModel {
    protected Locale locale;
    public void setLocale(Locale locale) {
        this.locale = locale;
    }
    public Locale getLocale() {
        return locale;
    }
    public void validate(I18nService i18nService) throws ValidateException {

    }
}
