package site.daishuyang.springdemo;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.LocaleResolver;

public class LocalConfig implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String lang = request.getParameter("lang");
        if (lang == null) {
            return Locale.getDefault();
        }
        String[] s = lang.split("_");
        Locale locale = new Locale(s[0], s[1]);
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
    }

}
