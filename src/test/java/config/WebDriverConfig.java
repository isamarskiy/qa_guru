package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${env}.properties")
public interface WebDriverConfig extends Config {

    @Key("browser")
    String getBrowser();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("remote_driver")
    String remote();

    @Key("video_storage")
    String video_storage();
}