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
package we.retail.core.api;


import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import we.retail.core.api.model.Voucher;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Component(
        name = "Voucher Resource API",
        label = "Voucher Resource API",
        description = "This component expose REST API to get voucher information",
        metatype = true,
        immediate = true)
@Service(value = VoucherResource.class)
@Path("/discoverasr/vouchers")
@Produces(MediaType.APPLICATION_JSON)
public class VoucherResource {
    @GET
    @Path("hello")
    public Voucher helloWorld() {
        return new Voucher("Hello World", 10);
    }

    @GET
    @Path("{languageCode}.json")
    public Voucher getVouchersByLanguageCode(@PathParam("languageCode") String languageCode) {
        return new Voucher("languageCode - " + languageCode, 10);
    }

    @GET
    @Path("{languageCode}/{array}.json")
    public Voucher getVouchersByArray(@PathParam("languageCode") String languageCode,
                                      @PathParam("array") String array) {
        String voucherName = String.format("languageCode: %s. array: %s", languageCode, array);
        return new Voucher(voucherName, 10);
    }

    @GET
    @Path("{languageCode}/by-id/{id}.json")
    public Voucher getVoucherDetail(@PathParam("languageCode") String languageCode,
                                    @PathParam("id") String id) {
        String voucherName = String.format("languageCode: %s. id: %s", languageCode, id);
        return new Voucher(voucherName, 10);
    }

}
