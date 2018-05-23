package org.davidmoten.rx2.io;

import java.io.IOException;
import java.nio.ByteBuffer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.davidmoten.rx2.http.FlowableHttpServlet;

import io.reactivex.Flowable;

public final class HandlerServlet extends FlowableHttpServlet {

    private static final long serialVersionUID = 4294026368929063494L;

    public static Flowable<ByteBuffer> flowable = Flowable.empty();

    public HandlerServlet() {
        super(flowable);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
