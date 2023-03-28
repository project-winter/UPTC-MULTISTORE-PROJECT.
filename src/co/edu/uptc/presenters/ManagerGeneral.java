package co.edu.uptc.presenters;

import co.edu.uptc.models.BryanModel.MyManagerModel;
import co.edu.uptc.models.ModelGerman.ManagerModel;
import co.edu.uptc.views.dashBoard.DashBoard;

import java.util.List;

public class ManagerGeneral {
    private static ManagerGeneral instance;
    ContratBills.View view;
    ContratBills.Model modelGerman;
    ContratBills.Model bryanModel;
    ContratBills.Presenter presenter;

    private ManagerGeneral() {
    }

    private void createMVP(){
         view = new DashBoard();
         presenter = new Presenter();
         view.setPresenter(presenter);
         presenter.setView(view);
         createModels();
         configModelUserGerman();
     }

     public static ManagerGeneral getInstance(){
         return instance==null?instance = new ManagerGeneral():instance;
     }


     private void createModels(){
         // TODO aqui se cream todos los modelos
         modelGerman = new ManagerModel();
         bryanModel = new MyManagerModel();

     }

     public void configModelUserGerman(){
         modelGerman.setPresenter(presenter);
         presenter.setModel(modelGerman);
         view.updatedPeople();
     }

    public void configModelOtherUser(){
        // TODO  aqui se configura para cado estudiante el modelo y este metodo se llama desde la vista
        bryanModel.setPresenter(presenter);
        presenter.setModel(bryanModel);
        view.updatedPeople();
    }
    public void configBryanModel(){
        // TODO  aqui se configura para cado estudiante el modelo y este metodo se llama desde la vista
        bryanModel.setPresenter(presenter);
        presenter.setModel(bryanModel);
        view.updatedPeople();
    }


    public void runProject(){
        createMVP();
        view.start();
    }

}
