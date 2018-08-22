/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.sql.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.CloudException;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in ElasticPoolActivities.
 */
public class ElasticPoolActivitiesInner {
    /** The Retrofit service to perform REST calls. */
    private ElasticPoolActivitiesService service;
    /** The service client containing this operation class. */
    private SqlManagementClientImpl client;

    /**
     * Initializes an instance of ElasticPoolActivitiesInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public ElasticPoolActivitiesInner(Retrofit retrofit, SqlManagementClientImpl client) {
        this.service = retrofit.create(ElasticPoolActivitiesService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for ElasticPoolActivities to be
     * used by Retrofit to perform actually REST calls.
     */
    interface ElasticPoolActivitiesService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.sql.ElasticPoolActivities listByElasticPool" })
        @GET("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Sql/servers/{serverName}/elasticPools/{elasticPoolName}/elasticPoolActivity")
        Observable<Response<ResponseBody>> listByElasticPool(@Path("subscriptionId") String subscriptionId, @Path("resourceGroupName") String resourceGroupName, @Path("serverName") String serverName, @Path("elasticPoolName") String elasticPoolName, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Returns elastic pool activities.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @param elasticPoolName The name of the elastic pool for which to get the current activity.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the List&lt;ElasticPoolActivityInner&gt; object if successful.
     */
    public List<ElasticPoolActivityInner> listByElasticPool(String resourceGroupName, String serverName, String elasticPoolName) {
        return listByElasticPoolWithServiceResponseAsync(resourceGroupName, serverName, elasticPoolName).toBlocking().single().body();
    }

    /**
     * Returns elastic pool activities.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @param elasticPoolName The name of the elastic pool for which to get the current activity.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<ElasticPoolActivityInner>> listByElasticPoolAsync(String resourceGroupName, String serverName, String elasticPoolName, final ServiceCallback<List<ElasticPoolActivityInner>> serviceCallback) {
        return ServiceFuture.fromResponse(listByElasticPoolWithServiceResponseAsync(resourceGroupName, serverName, elasticPoolName), serviceCallback);
    }

    /**
     * Returns elastic pool activities.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @param elasticPoolName The name of the elastic pool for which to get the current activity.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the List&lt;ElasticPoolActivityInner&gt; object
     */
    public Observable<List<ElasticPoolActivityInner>> listByElasticPoolAsync(String resourceGroupName, String serverName, String elasticPoolName) {
        return listByElasticPoolWithServiceResponseAsync(resourceGroupName, serverName, elasticPoolName).map(new Func1<ServiceResponse<List<ElasticPoolActivityInner>>, List<ElasticPoolActivityInner>>() {
            @Override
            public List<ElasticPoolActivityInner> call(ServiceResponse<List<ElasticPoolActivityInner>> response) {
                return response.body();
            }
        });
    }

    /**
     * Returns elastic pool activities.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @param elasticPoolName The name of the elastic pool for which to get the current activity.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the List&lt;ElasticPoolActivityInner&gt; object
     */
    public Observable<ServiceResponse<List<ElasticPoolActivityInner>>> listByElasticPoolWithServiceResponseAsync(String resourceGroupName, String serverName, String elasticPoolName) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (serverName == null) {
            throw new IllegalArgumentException("Parameter serverName is required and cannot be null.");
        }
        if (elasticPoolName == null) {
            throw new IllegalArgumentException("Parameter elasticPoolName is required and cannot be null.");
        }
        final String apiVersion = "2014-04-01";
        return service.listByElasticPool(this.client.subscriptionId(), resourceGroupName, serverName, elasticPoolName, apiVersion, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<List<ElasticPoolActivityInner>>>>() {
                @Override
                public Observable<ServiceResponse<List<ElasticPoolActivityInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<ElasticPoolActivityInner>> result = listByElasticPoolDelegate(response);
                        ServiceResponse<List<ElasticPoolActivityInner>> clientResponse = new ServiceResponse<List<ElasticPoolActivityInner>>(result.body().items(), result.response());
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<ElasticPoolActivityInner>> listByElasticPoolDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<ElasticPoolActivityInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<ElasticPoolActivityInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}
