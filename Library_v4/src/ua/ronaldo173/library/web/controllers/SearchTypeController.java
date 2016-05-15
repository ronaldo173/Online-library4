package ua.ronaldo173.library.web.controllers;

import ua.ronaldo173.library.web.enums.SearchType;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Santer on 18.04.2016.
 */
@ManagedBean
@RequestScoped
public class SearchTypeController {
    private static Map<String, SearchType> searchList = new HashMap<>();

    public SearchTypeController() {
        ResourceBundle bundle = ResourceBundle.getBundle("ua.ronaldo173.library.web.nls.messages",
                FacesContext.getCurrentInstance().getViewRoot().getLocale());
        searchList.clear();
        searchList.put(bundle.getString("author_name"), SearchType.AUTHOR);
        searchList.put(bundle.getString("book_name"), SearchType.TITLE);
    }

    public Map<String, SearchType> getSearchList() {
        return searchList;
    }
}
