/**
 * ======================================================================
 * File Name: GameGUIController.java
 * Project Name: Final Game Project
 * ======================================================================
 * Creators: Sam Compson
 * Date Created:
 * Course: CSCI-1260-942
 * ======================================================================
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PuzzleGUIController {

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image3;

    @FXML
    private ImageView image4;

    @FXML
    private ImageView image5;

    @FXML
    private ImageView image6;

    @FXML
    private ImageView image7;

    @FXML
    private ImageView image8;

    @FXML
    private ImageView image9;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    public Button[] buttons;

    public ImageView[] imageViews;
    public Image[] imagesCorrect;

    public Image[] images;

    public Mansion m;

    public Player p;


    public int buttonX1 = -5;
    public int buttonY1 = -5;
    public int buttonX2 = -5;
    public int buttonY2 = -5;
    public int buttonIndex1 = -5;
    public int buttonIndex2 = -5;

    void randomizeImages() {
        //Put all image files into two arrays
        for(int i = 0; i < imageViews.length; i++){
            images[i] = imageViews[i].getImage();
            //This stores the proper order of the images in the imagesCorrect array
            imagesCorrect[i] = imageViews[i].getImage();
        }
        //Randomize positions of images in that array
        List<Image> imageList = Arrays.asList(images);
        Collections.shuffle(imageList);
        imageList.toArray(images);

        //Put the randomized images back into the image views
        for(int i = 0; i < imageViews.length; i++) {
            imageViews[i].setImage(images[i]);
        }
    }

    void initialize(Mansion m, Player p) {
        //sets size of images array to 9
        images = new Image[9];
        //Gets in the mansion and player objects from GameGUI
        this.m = m;
        this.p = p;
        //Create buttons, and image view arrays
        buttons = new Button[]{button1, button2, button3, button4, button5, button6, button7, button8, button9};
        imageViews = new ImageView[]{image1, image2, image3, image4, image5, image6, image7, image8, image9};
        //Set correct images array size
        imagesCorrect = new Image[9];
        randomizeImages();
    }

    void move() {
        //Create temp variable to store image during swap
        Image temp;
        temp = imageViews[buttonIndex1].getImage();
        //Swap images
        imageViews[buttonIndex1].setImage(imageViews[buttonIndex2].getImage());
        imageViews[buttonIndex2].setImage(temp);
        //Set these variables back to default values
        buttonIndex1 = -5;
        buttonIndex2 = -5;
        buttonX1 = -5;
        buttonY1 = -5;
        buttonX2 = -5;
        buttonY2 = -5;
    }

    void detectButton(Button b, int i) {
        //Set opacity so that you can see which button has been clicked
        imageViews[i].setOpacity(0.5);
        //The if else checks to see if you have already clicked 1 button or not
        if (buttonIndex1 == -5) {
            buttonIndex1 = i;
            buttonX1 = i%3 + 1;
            buttonY1 = i/3 + 1;
        }
        else {
            buttonIndex2 = i;
            buttonX2 = i%3 + 1;
            buttonY2 = i/3 + 1;
        }
        //Can only move a square to adjacent squares
        if(!((buttonX2 == (buttonX1 + 1) && buttonY2 == buttonY1) || (buttonX2 == (buttonX1 - 1) && buttonY2 == buttonY1)
                || (buttonY2 == (buttonY1 + 1) && buttonX2 == buttonX1) || (buttonY2 == (buttonY1 - 1) && buttonX2 == buttonX1))) {
            if (buttonIndex2 >= 0 && buttonIndex1 != buttonIndex2)
                imageViews[i].setOpacity(1);
            buttonIndex2 = -5;
        }
        //If both buttons have been pressed
        if(buttonIndex2>=0) {
            move();
            for(ImageView i2: imageViews)
                i2.setOpacity(1);
        }
    }

    Boolean checkWin() {
        Boolean win = true;
        //Check to make sure all images are in the proper spot
        for(int i = 0; i < 9; i++) {
            if(imageViews[i].getImage().equals(imagesCorrect[i]) && win)
                win = true;
            else
                win = false;
        }
        return win;
    }

    void doWin() {
        //Add blank item to avoid ConcurrentModificationException
        //Remove the puzzle box from inventory
        Item toRemove = null;
        for(Item i: p.getInventory()) {
            if(i.getName().equalsIgnoreCase("puzzle box"))
                toRemove = i;
        }
        p.getInventory().remove(toRemove);
        //Add the clue to players inventory that was "in" the puzzle box
        p.getInventory().add(m.getRoom("Dev").getContents().get(0));
        //Close this window
        Stage thisWindow = (Stage) button9.getScene().getWindow();
        thisWindow.close();
    }

    @FXML
    void button1Pressed(ActionEvent event) {
        detectButton(button1, 0);
        if(checkWin()) {
            doWin();
        }
    }

    @FXML
    void button2Pressed(ActionEvent event) {
        detectButton(button2, 1);
        if(checkWin())
            doWin();
    }

    @FXML
    void button3Pressed(ActionEvent event) {
        detectButton(button3, 2);
        if(checkWin())
            doWin();
    }

    @FXML
    void button4Pressed(ActionEvent event) {
        detectButton(button4, 3);
        if(checkWin())
            doWin();
    }

    @FXML
    void button5Pressed(ActionEvent event) {
        detectButton(button5, 4);
        if(checkWin())
            doWin();
    }

    @FXML
    void button6Pressed(ActionEvent event) {
        detectButton(button6, 5);
        if(checkWin())
            doWin();
    }

    @FXML
    void button7Pressed(ActionEvent event) {
        detectButton(button7, 6);
        if(checkWin())
            doWin();
    }

    @FXML
    void button8Pressed(ActionEvent event) {
        detectButton(button8, 7);
        if(checkWin())
            doWin();
    }

    @FXML
    void button9Pressed(ActionEvent event) {
        detectButton(button9, 8);
        if(checkWin())
            doWin();
    }

}
