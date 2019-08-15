package com.wallethhub.qa.pages;


/**
 * Contains elements locator
 */
public class Locators {

    /* Landing Page Locators */

    public static final class LandingPage {

        public static final String SIGN_UP_PAGE_BTN = "//a[@class='navLink--2aGgl button--IIPPe']";
        public static final String COOKIE_INFORMATION_LABEL = "//p[@class='cookieInformation--2m9KY']";
        public static final String PRIVACY_POLICY_BTN = "//a[@class='base--3CR4A link--2D7-A overlay--8tamw']";
        public static final String NO_PROBLEM_BTN = "//button[contains(text(),'No problem')]";
    }
    /* SIGN UP Page Locators */
    public static final class SignUpPage {

        public static final String SUBMIT_BTN = "//button[@type='submit']";
        public static final String EMAIL_ADDRESS_TEXTFIELD = "signupform_email_input";
        public static final String COUNTRY_LIST_BTN = "signupform_region_input";
        public static final String INDIA_OPTION = "in";
        public static final String UK_OPTION = "gb";
        public static final String SA_OPTION = "za";
        public static final String STEP_ONE_LABEL = "//div[@class='stepProgress--1qv1N active--ydCzl']";

    }

    /* Facebook SIGN in Page Locators */
    public static final class FacebookSignInPage {

        public static final String EMAIL_ADDRESS_TEXTFIELD = "email";
        public static final String PASSWORD_TEXTFILED = "pass";
        public static final String LOGIN_BUTTON = "loginbutton";
        public static final String NOTIFICATION_BELL_BUTTON = "fbNotificationsJewel";
        public static final String STATUS_TEXTFIELD = "/html/body/div[1]/div[3]/div[1]/div/div[2]/div[2]/div[1]/div[2]/div/div[3]/div/div/div[2]/div/div/div/form/div[1]/div/div[2]";
        public static final String WRITE_POST_TEXTFIELD="//textarea[@name='xhpc_message']";
        public static final String POST_BTN = "//button/span[.=\"Post\"]";

    }

    /* Wallet Hub Page Locators */
    public static final class WalletHubPage {

        public static final String LOGIN_TAB_BUTTON = "//span[@class='brgm-button brgm-signup']";
        public static final String EMAIL_TEXTFILED = "//input[@placeholder='Email Address']";
        public static final String PASSWORD_TEXTFILED = "//input[@placeholder='Password']";
        public static final String LOGIN_BUTTON = "//div[@class='btns']//button[2]";
        public static final String USERNAME="/html[1]/body[1]/web-app[1]/div[1]/header[1]/div[1]/nav[1]/div[5]/span[1]";
        public static final String WHATS_YOUR_RATING_LABEL = "/html[1]/body[1]/web-app[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div/section/div/div/review-star";
        public static final String STAR_BUTTON = ".review-action > review-star:nth-child(2) > div:nth-child(1) > svg:nth-child(1)";
        public static final String SELECT_BUTTON = "//span[contains(text(),'Select...')]";
        public static final String HEALTH_INSURANCES_BUTTON = "//li[contains(text(),'Health Insurance')]";
        public static final String REVIEW_TEXTFIELD = "//textarea[@placeholder='Write your review...']";
        public static final String SUBMIT_BUTTON = "//div[@class='sbn-action semi-bold-font btn fixed-w-c tall']";
        public static final String ACTIVITY_BTN = "/html/body/div[3]/div/div[1]/div[1]/div[2]/ul/li[2]/a";
        public static final String REVIEW_TEXT = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[3]/div[1]/div[2]/p[1]";

    }
}
