package tests;

import config.ConfigManager;
import pages.ElementsPage;
import pages.MainPage;
import pages.TextBoxPage;

public class BaseTest extends ConfigManager {
    MainPage mainPage = new MainPage();
    ElementsPage elementsPage = new ElementsPage();
    TextBoxPage textBoxPage = new TextBoxPage();


}
