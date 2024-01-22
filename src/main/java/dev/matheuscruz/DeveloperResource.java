package dev.matheuscruz;

import java.net.URI;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.nosql.document.DocumentTemplate;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/devs")
public class DeveloperResource {

    @Inject
    DocumentTemplate template;

    @POST
    public Response create(DevRequest request) {

        Developer dev = new Developer(request.name, request.github);
        Developer newDev = template.insert(dev);
        return Response.created(URI.create("/devs/" + newDev.getId())).build();
    }

    @GET
    public Response all() {
        List<Developer> all = template.select(Developer.class).result();
        return Response.ok(all).build();
    }

    record DevRequest(String name, String github) {
    }
}
