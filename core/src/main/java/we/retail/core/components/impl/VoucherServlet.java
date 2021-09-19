/*
 *   Copyright 2016 Adobe Systems Incorporated
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package we.retail.core.components.impl;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import we.retail.core.api.model.Voucher;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Component
@Service
@Properties(value = {
        @Property(name = Constants.SERVICE_DESCRIPTION, value = "Provides Voucher services for We.Retail vouchers"),
        @Property(name = "sling.servlet.resourceTypes", value = "weretail/components/structure/page"),
        @Property(name = "sling.servlet.selectors", value = {"hello"}),
        @Property(name = "sling.servlet.extensions", value = {"json"}),
        @Property(name = "sling.servlet.methods", value = HttpConstants.METHOD_GET)
})
public class VoucherServlet extends SlingSafeMethodsServlet {
    @Override
    protected void doGet(@Nonnull SlingHttpServletRequest request, @Nonnull SlingHttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        PrintWriter printWriter = response.getWriter();
        List<Voucher> result = new ArrayList<>();
        result.add(new Voucher("ABC", 10));
        Gson gson = new GsonBuilder().create();
        String resultJson = gson.toJson(result);
        printWriter.print(resultJson);
        printWriter.flush();
    }
}
