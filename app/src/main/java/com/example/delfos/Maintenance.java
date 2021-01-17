package com.example.delfos;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;


public class Maintenance
{

    private String Murl ="http://testedelfos.000webhostapp.com/";


    public void validarlogin(final Context context, String nome, String senha){

        String url = Murl + "connect/logar.php";

        Ion.with(context)
                .load(url)
                .setBodyParameter("nome", nome)
                .setBodyParameter("senha", senha)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {



                   try {
                                User usuario = new User();
                                usuario.setUser(result.getAsJsonPrimitive("nome").getAsString());
                                usuario.setPassword(result.getAsJsonPrimitive("senha").getAsString());
                                usuario.setLevel(result.getAsJsonPrimitive("level").getAsString());

                                if(usuario.getUser() != "" )
                                {
                                    context.startActivity( new Intent(context, Level1.class));
                                }

                                else
                                    {
                                        Toast.makeText(context,"Usuario não encontrado", Toast.LENGTH_LONG).show();
                                }




                        }
                        catch(Exception ex){
                            ex.printStackTrace();
                        }
                    }
                });
    }

    public void registerUser(final Context context, String login, String password){
        String url = Murl + "CadastrarUsuario.php";

        Ion.with(context)
                .load(url)
                .setBodyParameter("nome", login)
                .setBodyParameter("senha", password)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        try {

                            String RETORNO = result.get("CADASTRO").getAsString();
                            if(RETORNO.equals("SUCESSO")){
                                Toast.makeText(context,"cadastro efetuado com Sucesso", Toast.LENGTH_LONG).show();
                            }
                            else{
                                Toast.makeText(context, "Erro ao Cadastrar", Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
    }

    public void misao(final Context context, String login, String password){
        String url = Murl + "CadastrarUsuario.php";

        Ion.with(context)
                .load(url)
                .setBodyParameter("level", login)
                .setBodyParameter("senha", password)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        try {

                            String RETORNO = result.get("CADASTRO").getAsString();
                            if(RETORNO.equals("SUCESSO")){
                                Toast.makeText(context,"cadastro efetuado com Sucesso", Toast.LENGTH_LONG).show();
                            }
                            else{
                                Toast.makeText(context, "Erro ao Cadastrar", Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
    }



}
