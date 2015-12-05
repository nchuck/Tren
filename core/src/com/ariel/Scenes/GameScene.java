package com.ariel.Scenes;

import com.ariel.IScripts.Tren;
import com.ariel.Stages.HUD;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.uwsoft.editor.renderer.SceneLoader;
import com.uwsoft.editor.renderer.utils.ItemWrapper;

public class GameScene extends BaseSceneConfig {

    private LEVEL current = LEVEL.L1;

    public GameScene(String sceneName, SceneLoader sceneLoader, Viewport viewport, Stage uiStage) {
        super(sceneName, sceneLoader, viewport, uiStage);
    }

    public enum LEVEL{
        L1, L2
    }

    public String getLevelName(){
        switch (current){
            case L1:
                return "MainScene";
            case L2:
                return "Nivel2";
        }
        return "Menu";
    }

    public void setLevel(LEVEL newLevel){
        this.current = newLevel;
    }

    @Override
    public void addScripts() {
        super.addScripts();
        // Cargamos el script del tren
        Tren tren = new Tren((OrthographicCamera)viewport.getCamera(),(HUD)stage);
        // Se le asigna
        rootWrapper.getChild("tren").addScript(tren);
    }
}
