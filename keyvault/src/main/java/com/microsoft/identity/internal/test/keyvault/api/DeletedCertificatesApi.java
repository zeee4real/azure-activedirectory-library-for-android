/*
 * KeyVaultClient
 * The key vault client performs cryptographic key operations and vault operations against the Key Vault service.
 *
 * OpenAPI spec version: 2016-10-01
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.microsoft.identity.internal.test.keyvault.api;

import com.microsoft.identity.internal.test.keyvault.ApiCallback;
import com.microsoft.identity.internal.test.keyvault.ApiClient;
import com.microsoft.identity.internal.test.keyvault.ApiException;
import com.microsoft.identity.internal.test.keyvault.ApiResponse;
import com.microsoft.identity.internal.test.keyvault.Configuration;
import com.microsoft.identity.internal.test.keyvault.Pair;
import com.microsoft.identity.internal.test.keyvault.ProgressRequestBody;
import com.microsoft.identity.internal.test.keyvault.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;
import com.microsoft.identity.internal.test.keyvault.model.CertificateBundle;
import com.microsoft.identity.internal.test.keyvault.model.DeletedCertificateBundle;
import com.microsoft.identity.internal.test.keyvault.model.DeletedCertificateListResult;

import java.io.IOException;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeletedCertificatesApi {
    private ApiClient apiClient;

    public DeletedCertificatesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public DeletedCertificatesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for getDeletedCertificate
     * @param certificateName The name of the certificate (required)
     * @param apiVersion Client API version. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getDeletedCertificateCall(String certificateName, String apiVersion, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/deletedcertificates/{certificate-name}"
            .replaceAll("\\{" + "certificate-name" + "\\}", apiClient.escapeString(certificateName.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (apiVersion != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("api-version", apiVersion));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getDeletedCertificateValidateBeforeCall(String certificateName, String apiVersion, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'certificateName' is set
        if (certificateName == null) {
            throw new ApiException("Missing the required parameter 'certificateName' when calling getDeletedCertificate(Async)");
        }
        
        // verify the required parameter 'apiVersion' is set
        if (apiVersion == null) {
            throw new ApiException("Missing the required parameter 'apiVersion' when calling getDeletedCertificate(Async)");
        }
        

        com.squareup.okhttp.Call call = getDeletedCertificateCall(certificateName, apiVersion, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Retrieves information about the specified deleted certificate.
     * The GetDeletedCertificate operation retrieves the deleted certificate information plus its attributes, such as retention interval, scheduled permanent deletion and the current deletion recovery level. This operation requires the certificates/get permission.
     * @param certificateName The name of the certificate (required)
     * @param apiVersion Client API version. (required)
     * @return DeletedCertificateBundle
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DeletedCertificateBundle getDeletedCertificate(String certificateName, String apiVersion) throws ApiException {
        ApiResponse<DeletedCertificateBundle> resp = getDeletedCertificateWithHttpInfo(certificateName, apiVersion);
        return resp.getData();
    }

    /**
     * Retrieves information about the specified deleted certificate.
     * The GetDeletedCertificate operation retrieves the deleted certificate information plus its attributes, such as retention interval, scheduled permanent deletion and the current deletion recovery level. This operation requires the certificates/get permission.
     * @param certificateName The name of the certificate (required)
     * @param apiVersion Client API version. (required)
     * @return ApiResponse&lt;DeletedCertificateBundle&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DeletedCertificateBundle> getDeletedCertificateWithHttpInfo(String certificateName, String apiVersion) throws ApiException {
        com.squareup.okhttp.Call call = getDeletedCertificateValidateBeforeCall(certificateName, apiVersion, null, null);
        Type localVarReturnType = new TypeToken<DeletedCertificateBundle>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Retrieves information about the specified deleted certificate. (asynchronously)
     * The GetDeletedCertificate operation retrieves the deleted certificate information plus its attributes, such as retention interval, scheduled permanent deletion and the current deletion recovery level. This operation requires the certificates/get permission.
     * @param certificateName The name of the certificate (required)
     * @param apiVersion Client API version. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getDeletedCertificateAsync(String certificateName, String apiVersion, final ApiCallback<DeletedCertificateBundle> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getDeletedCertificateValidateBeforeCall(certificateName, apiVersion, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DeletedCertificateBundle>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getDeletedCertificates
     * @param apiVersion Client API version. (required)
     * @param maxresults Maximum number of results to return in a page. If not specified the service will return up to 25 results. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getDeletedCertificatesCall(String apiVersion, Integer maxresults, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/deletedcertificates";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (maxresults != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("maxresults", maxresults));
        if (apiVersion != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("api-version", apiVersion));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getDeletedCertificatesValidateBeforeCall(String apiVersion, Integer maxresults, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiVersion' is set
        if (apiVersion == null) {
            throw new ApiException("Missing the required parameter 'apiVersion' when calling getDeletedCertificates(Async)");
        }
        

        com.squareup.okhttp.Call call = getDeletedCertificatesCall(apiVersion, maxresults, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Lists the deleted certificates in the specified vault currently available for recovery.
     * The GetDeletedCertificates operation retrieves the certificates in the current vault which are in a deleted state and ready for recovery or purging. This operation includes deletion-specific information. This operation requires the certificates/get/list permission. This operation can only be enabled on soft-delete enabled vaults.
     * @param apiVersion Client API version. (required)
     * @param maxresults Maximum number of results to return in a page. If not specified the service will return up to 25 results. (optional)
     * @return DeletedCertificateListResult
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DeletedCertificateListResult getDeletedCertificates(String apiVersion, Integer maxresults) throws ApiException {
        ApiResponse<DeletedCertificateListResult> resp = getDeletedCertificatesWithHttpInfo(apiVersion, maxresults);
        return resp.getData();
    }

    /**
     * Lists the deleted certificates in the specified vault currently available for recovery.
     * The GetDeletedCertificates operation retrieves the certificates in the current vault which are in a deleted state and ready for recovery or purging. This operation includes deletion-specific information. This operation requires the certificates/get/list permission. This operation can only be enabled on soft-delete enabled vaults.
     * @param apiVersion Client API version. (required)
     * @param maxresults Maximum number of results to return in a page. If not specified the service will return up to 25 results. (optional)
     * @return ApiResponse&lt;DeletedCertificateListResult&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DeletedCertificateListResult> getDeletedCertificatesWithHttpInfo(String apiVersion, Integer maxresults) throws ApiException {
        com.squareup.okhttp.Call call = getDeletedCertificatesValidateBeforeCall(apiVersion, maxresults, null, null);
        Type localVarReturnType = new TypeToken<DeletedCertificateListResult>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Lists the deleted certificates in the specified vault currently available for recovery. (asynchronously)
     * The GetDeletedCertificates operation retrieves the certificates in the current vault which are in a deleted state and ready for recovery or purging. This operation includes deletion-specific information. This operation requires the certificates/get/list permission. This operation can only be enabled on soft-delete enabled vaults.
     * @param apiVersion Client API version. (required)
     * @param maxresults Maximum number of results to return in a page. If not specified the service will return up to 25 results. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getDeletedCertificatesAsync(String apiVersion, Integer maxresults, final ApiCallback<DeletedCertificateListResult> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getDeletedCertificatesValidateBeforeCall(apiVersion, maxresults, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DeletedCertificateListResult>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for purgeDeletedCertificate
     * @param certificateName The name of the certificate (required)
     * @param apiVersion Client API version. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call purgeDeletedCertificateCall(String certificateName, String apiVersion, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/deletedcertificates/{certificate-name}"
            .replaceAll("\\{" + "certificate-name" + "\\}", apiClient.escapeString(certificateName.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (apiVersion != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("api-version", apiVersion));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call purgeDeletedCertificateValidateBeforeCall(String certificateName, String apiVersion, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'certificateName' is set
        if (certificateName == null) {
            throw new ApiException("Missing the required parameter 'certificateName' when calling purgeDeletedCertificate(Async)");
        }
        
        // verify the required parameter 'apiVersion' is set
        if (apiVersion == null) {
            throw new ApiException("Missing the required parameter 'apiVersion' when calling purgeDeletedCertificate(Async)");
        }
        

        com.squareup.okhttp.Call call = purgeDeletedCertificateCall(certificateName, apiVersion, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Permanently deletes the specified deleted certificate.
     * The PurgeDeletedCertificate operation performs an irreversible deletion of the specified certificate, without possibility for recovery. The operation is not available if the recovery level does not specify &#39;Purgeable&#39;. This operation requires the certificate/purge permission.
     * @param certificateName The name of the certificate (required)
     * @param apiVersion Client API version. (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void purgeDeletedCertificate(String certificateName, String apiVersion) throws ApiException {
        purgeDeletedCertificateWithHttpInfo(certificateName, apiVersion);
    }

    /**
     * Permanently deletes the specified deleted certificate.
     * The PurgeDeletedCertificate operation performs an irreversible deletion of the specified certificate, without possibility for recovery. The operation is not available if the recovery level does not specify &#39;Purgeable&#39;. This operation requires the certificate/purge permission.
     * @param certificateName The name of the certificate (required)
     * @param apiVersion Client API version. (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> purgeDeletedCertificateWithHttpInfo(String certificateName, String apiVersion) throws ApiException {
        com.squareup.okhttp.Call call = purgeDeletedCertificateValidateBeforeCall(certificateName, apiVersion, null, null);
        return apiClient.execute(call);
    }

    /**
     * Permanently deletes the specified deleted certificate. (asynchronously)
     * The PurgeDeletedCertificate operation performs an irreversible deletion of the specified certificate, without possibility for recovery. The operation is not available if the recovery level does not specify &#39;Purgeable&#39;. This operation requires the certificate/purge permission.
     * @param certificateName The name of the certificate (required)
     * @param apiVersion Client API version. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call purgeDeletedCertificateAsync(String certificateName, String apiVersion, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = purgeDeletedCertificateValidateBeforeCall(certificateName, apiVersion, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for recoverDeletedCertificate
     * @param certificateName The name of the deleted certificate (required)
     * @param apiVersion Client API version. (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call recoverDeletedCertificateCall(String certificateName, String apiVersion, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/deletedcertificates/{certificate-name}/recover"
            .replaceAll("\\{" + "certificate-name" + "\\}", apiClient.escapeString(certificateName.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (apiVersion != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("api-version", apiVersion));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call recoverDeletedCertificateValidateBeforeCall(String certificateName, String apiVersion, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'certificateName' is set
        if (certificateName == null) {
            throw new ApiException("Missing the required parameter 'certificateName' when calling recoverDeletedCertificate(Async)");
        }
        
        // verify the required parameter 'apiVersion' is set
        if (apiVersion == null) {
            throw new ApiException("Missing the required parameter 'apiVersion' when calling recoverDeletedCertificate(Async)");
        }
        

        com.squareup.okhttp.Call call = recoverDeletedCertificateCall(certificateName, apiVersion, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Recovers the deleted certificate back to its current version under /certificates.
     * The RecoverDeletedCertificate operation performs the reversal of the Delete operation. The operation is applicable in vaults enabled for soft-delete, and must be issued during the retention interval (available in the deleted certificate&#39;s attributes). This operation requires the certificates/recover permission.
     * @param certificateName The name of the deleted certificate (required)
     * @param apiVersion Client API version. (required)
     * @return CertificateBundle
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CertificateBundle recoverDeletedCertificate(String certificateName, String apiVersion) throws ApiException {
        ApiResponse<CertificateBundle> resp = recoverDeletedCertificateWithHttpInfo(certificateName, apiVersion);
        return resp.getData();
    }

    /**
     * Recovers the deleted certificate back to its current version under /certificates.
     * The RecoverDeletedCertificate operation performs the reversal of the Delete operation. The operation is applicable in vaults enabled for soft-delete, and must be issued during the retention interval (available in the deleted certificate&#39;s attributes). This operation requires the certificates/recover permission.
     * @param certificateName The name of the deleted certificate (required)
     * @param apiVersion Client API version. (required)
     * @return ApiResponse&lt;CertificateBundle&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CertificateBundle> recoverDeletedCertificateWithHttpInfo(String certificateName, String apiVersion) throws ApiException {
        com.squareup.okhttp.Call call = recoverDeletedCertificateValidateBeforeCall(certificateName, apiVersion, null, null);
        Type localVarReturnType = new TypeToken<CertificateBundle>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Recovers the deleted certificate back to its current version under /certificates. (asynchronously)
     * The RecoverDeletedCertificate operation performs the reversal of the Delete operation. The operation is applicable in vaults enabled for soft-delete, and must be issued during the retention interval (available in the deleted certificate&#39;s attributes). This operation requires the certificates/recover permission.
     * @param certificateName The name of the deleted certificate (required)
     * @param apiVersion Client API version. (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call recoverDeletedCertificateAsync(String certificateName, String apiVersion, final ApiCallback<CertificateBundle> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = recoverDeletedCertificateValidateBeforeCall(certificateName, apiVersion, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CertificateBundle>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}