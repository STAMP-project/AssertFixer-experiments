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
 * in DatabaseUsages.
 */
public class DatabaseUsagesInner {
    /** The Retrofit service to perform REST calls. */
    private DatabaseUsagesService service;
    /** The service client containing this operation class. */
    private SqlManagementClientImpl client;

    /**
     * Initializes an instance of DatabaseUsagesInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public DatabaseUsagesInner(Retrofit retrofit, SqlManagementClientImpl client) {
        this.service = retrofit.create(DatabaseUsagesService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for DatabaseUsages to be
     * used by Retrofit to perform actually REST calls.
     */
    interface DatabaseUsagesService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.sql.DatabaseUsages listByDatabase" })
        @GET("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Sql/servers/{serverName}/databases/{databaseName}/usages")
        Observable<Response<ResponseBody>> listByDatabase(@Path("subscriptionId") String subscriptionId, @Path("resourceGroupName") String resourceGroupName, @Path("serverName") String serverName, @Path("databaseName") String databaseName, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Returns database usages.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @param databaseName The name of the database.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the List&lt;DatabaseUsageInner&gt; object if successful.
     */
    public List<DatabaseUsageInner> listByDatabase(String resourceGroupName, String serverName, String databaseName) {
        return listByDatabaseWithServiceResponseAsync(resourceGroupName, serverName, databaseName).toBlocking().single().body();
    }

    /**
     * Returns database usages.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @param databaseName The name of the database.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<DatabaseUsageInner>> listByDatabaseAsync(String resourceGroupName, String serverName, String databaseName, final ServiceCallback<List<DatabaseUsageInner>> serviceCallback) {
        return ServiceFuture.fromResponse(listByDatabaseWithServiceResponseAsync(resourceGroupName, serverName, databaseName), serviceCallback);
    }

    /**
     * Returns database usages.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @param databaseName The name of the database.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the List&lt;DatabaseUsageInner&gt; object
     */
    public Observable<List<DatabaseUsageInner>> listByDatabaseAsync(String resourceGroupName, String serverName, String databaseName) {
        return listByDatabaseWithServiceResponseAsync(resourceGroupName, serverName, databaseName).map(new Func1<ServiceResponse<List<DatabaseUsageInner>>, List<DatabaseUsageInner>>() {
            @Override
            public List<DatabaseUsageInner> call(ServiceResponse<List<DatabaseUsageInner>> response) {
                return response.body();
            }
        });
    }

    /**
     * Returns database usages.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
     * @param serverName The name of the server.
     * @param databaseName The name of the database.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the List&lt;DatabaseUsageInner&gt; object
     */
    public Observable<ServiceResponse<List<DatabaseUsageInner>>> listByDatabaseWithServiceResponseAsync(String resourceGroupName, String serverName, String databaseName) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (serverName == null) {
            throw new IllegalArgumentException("Parameter serverName is required and cannot be null.");
        }
        if (databaseName == null) {
            throw new IllegalArgumentException("Parameter databaseName is required and cannot be null.");
        }
        final String apiVersion = "2014-04-01";
        return service.listByDatabase(this.client.subscriptionId(), resourceGroupName, serverName, databaseName, apiVersion, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<List<DatabaseUsageInner>>>>() {
                @Override
                public Observable<ServiceResponse<List<DatabaseUsageInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<DatabaseUsageInner>> result = listByDatabaseDelegate(response);
                        ServiceResponse<List<DatabaseUsageInner>> clientResponse = new ServiceResponse<List<DatabaseUsageInner>>(result.body().items(), result.response());
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<DatabaseUsageInner>> listByDatabaseDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<DatabaseUsageInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<DatabaseUsageInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}
