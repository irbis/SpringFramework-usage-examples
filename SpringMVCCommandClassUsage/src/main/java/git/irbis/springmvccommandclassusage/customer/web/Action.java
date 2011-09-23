package git.irbis.springmvccommandclassusage.customer.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.util.WebUtils;

/**
 *
 * @author Alexsey Nadtochey<irbis4lan@yandex.ua>
 */
enum Action {
    OK, APPLY, CANCEL;
    
    static Action instanceOf(HttpServletRequest request) {
        if (WebUtils.hasSubmitParameter(request, "ok"))
            return OK;
        if (WebUtils.hasSubmitParameter(request, "applly"))
            return APPLY;
        
        return CANCEL;
    }
}
