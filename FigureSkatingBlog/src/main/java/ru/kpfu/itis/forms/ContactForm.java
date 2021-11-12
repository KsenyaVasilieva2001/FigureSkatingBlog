package ru.kpfu.itis.forms;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import ru.kpfu.itis.exceptions.ValidateException;
import ru.kpfu.itis.services.I18nService;

public class ContactForm extends AbstractForm{
    private String name;
    private String email;
    private String text;
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getText() {
        return text;
    }
    @Override
    public void validate(I18nService i18nService) throws ValidateException {
        if(!EmailValidator.getInstance().isValid(email)) {
            throw new ValidateException("Некорректный email");
        }
        if(StringUtils.isBlank(name)) {
            throw new ValidateException("Введите имя");
        }
        if(StringUtils.isBlank(text)) {
            throw new ValidateException("Введите сообщение");
        }
    }
}
