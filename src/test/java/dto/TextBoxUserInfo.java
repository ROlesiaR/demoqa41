package dto;

import net.bytebuddy.description.TypeVariableSource;

public class TextBoxUserInfo {
    String name;
    String mail;
    String currentAddress;
    String permanentAddress;

    public TextBoxUserInfo() {
    }

    public String getName() {
        return name;
    }

    public TextBoxUserInfo withName(String name) {
        this.name = name;
        return this;

    }

    public String getMail() {
        return mail;
    }

    public TextBoxUserInfo withMail(String mail) {
        this.mail = mail;
        return this;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public TextBoxUserInfo withCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
        return this;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public TextBoxUserInfo withPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
        return this;
    }

}
