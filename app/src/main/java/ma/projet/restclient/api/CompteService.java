package ma.projet.restclient.api;

import ma.projet.restclient.entities.Compte;
import ma.projet.restclient.entities.CompteList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CompteService {
    // Récupérer tous les comptes en JSON
    @GET("banque/comptes")
    @Headers("Accept: application/json")
    Call<List<Compte>> getAllCompteJson();

    // Récupérer tous les comptes en XML
    @GET("banque/comptes")
    @Headers("Accept: application/xml")
    Call<CompteList> getAllCompteXml();

    // Récupérer un compte par son ID
    @GET("banque/comptes/{id}")
    Call<Compte> getCompteById(@Path("id") Long id);

    // Ajouter un nouveau compte en JSON
    @POST("banque/comptes")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Call<Compte> addCompteJson(@Body Compte compte);

    // Ajouter un nouveau compte en XML
    @POST("banque/comptes")
    @Headers({"Content-Type: application/xml", "Accept: application/xml"})
    Call<Compte> addCompteXml(@Body Compte compte);

    // Mettre à jour un compte existant en JSON
    @PUT("banque/comptes/{id}")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Call<Compte> updateCompteJson(@Path("id") Long id, @Body Compte compte);

    // Mettre à jour un compte existant en XML
    @PUT("banque/comptes/{id}")
    @Headers({"Content-Type: application/xml", "Accept: application/xml"})
    Call<Compte> updateCompteXml(@Path("id") Long id, @Body Compte compte);

    // Supprimer un compte
    @DELETE("banque/comptes/{id}")
    Call<Void> deleteCompte(@Path("id") Long id);
}