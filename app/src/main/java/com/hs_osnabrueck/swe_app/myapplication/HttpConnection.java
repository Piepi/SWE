package com.hs_osnabrueck.swe_app.myapplication;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Scanner;

public class HttpConnection extends AsyncTask<String, Void, String> {

    static private final int CONNECTION_TIMEOUT = 10000;

    private String resultHttpConnection;

    @Override
    protected String doInBackground(String... urls) {

        return requestServer(urls[0], urls[1]);
    }

    // onPostExecute displays the results of the AsyncTask.
    @Override
    protected void onPostExecute(String result) {
        result.replace("\\\\","");
        resultHttpConnection = result;

    }

    private static String getResponseText(InputStream inStream) {
        return new Scanner(inStream).useDelimiter("\\A").next();
    }


    public static String requestServer(String url, String put){

        HttpURLConnection urlConnection = null;

        try {

            URL urlToRequest = new URL(url);

            urlConnection = (HttpURLConnection)
                    urlToRequest.openConnection();
            urlConnection.setConnectTimeout(CONNECTION_TIMEOUT);
            //urlConnection.setReadTimeout(10000);

            // handle issues
            int statusCode = urlConnection.getResponseCode();
            if (statusCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
                // handle unauthorized (if service requires user login)
            } else if (statusCode != HttpURLConnection.HTTP_OK) {
                // handle any other errors, like 404, 500,..
            }

            if(put.compareTo("") != 0){
                urlConnection.setRequestMethod("PUT");
                OutputStreamWriter out = new OutputStreamWriter(
                        urlConnection.getOutputStream());
                out.write(put);
                out.close();
                InputStream in = new BufferedInputStream(
                        urlConnection.getInputStream());
                return new JSONObject(getResponseText(in)).toString();
            }else{
                InputStream in = new BufferedInputStream(
                        urlConnection.getInputStream());
                return new JSONObject(getResponseText(in)).toString();
            }

        } catch (MalformedURLException e) {
            // URL is invalid
        } catch (SocketTimeoutException e) {
            // data retrieval or connection timed out
        } catch (IOException e) {
            // could not read response body
            // (could not create input stream)
        } catch (JSONException e) {
            // response body is no valid JSON string
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return null;

    }

    public String getResultHttpConnection() {
        return resultHttpConnection;
    }

    public void setResultHttpConnection(String resultHttpConnection) {
        this.resultHttpConnection = resultHttpConnection;
    }

}
