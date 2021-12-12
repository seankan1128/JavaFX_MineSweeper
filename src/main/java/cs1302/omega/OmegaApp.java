package cs1302.omega;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;

/**
 * Class MinesweeperApp.
 */
public class OmegaApp extends Application {

    // The size of each mine and the minefield
    private static final int MINE_SIZE = 50;
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    // The number of mines in x and y axis inside minefield
    private static final int X_MINES = WIDTH / MINE_SIZE;
    private static final int Y_MINES = HEIGHT / MINE_SIZE;

    // Mine grid
    private Mine[][] grid = new Mine[X_MINES][Y_MINES];

    
    // demonstrate how to load local asset using "file:resources/"
    private Image bannerImage = new Image("file:resources/readme-banner.png");
    private ImageView banner = new ImageView(bannerImage);


    // some labels to display information
    private Label notice = new Label("\nModify the starter code to suit your needs.\n");
    private Label instructions = new Label("\nClick on the gray boxes to open the mine.\n");
    
    // Scene of the application
    private Scene scene;

    /**
     * Method to create a new game.
     * @return Pane, a minefield region
     */
    public Pane newGame() {
        Pane root = new Pane();
        root.setPrefSize(WIDTH, HEIGHT);

        // Initiate a mine field and add them to the grid
        for (int y = 0; y < Y_MINES; y++) {
            for (int x = 0; x < X_MINES; x++) {
                Mine mine = new Mine(x, y, Math.random() < 0.1); // 0.1 of the minefield has bomb

                grid[x][y] = mine;
                root.getChildren().add(mine); // Add the mine to the Pane
            }
        }

        // Setting up the numbers of adjacent bombs in each field
        for (int y = 0; y < Y_MINES; y++) {
            for (int x = 0; x < X_MINES; x++) {
                Mine mine = grid[x][y];

                if (mine.hasBomb) {
                    continue; // if mine has a bomb in it then theres no need to write a number
                }

                // filter only the mine with bombs in it
                // count the total number of bombs in filtered list
                long bombs = getNeighbors(mine).stream().filter(m -> m.hasBomb).count();

                // if theres at least one bomb
                // write the number of bomb in neighbors inside the mine
                if (bombs > 0) {
                    mine.text.setText(String.valueOf(bombs));
                }
            }
        }

        return root;
    }

    /**
     * Getting the number of adjacent mines of a mine in list.
     * @param mine
     * @return list of mine
     */
    private List<Mine> getNeighbors(Mine mine) {
        List<Mine> neighbors = new ArrayList<>();

        // The eight neighbors coordinate (consider the mine has 0,0 coordinate)
        int[] points = new int[] {
            -1, -1, // Bottom left
            -1, 0, // left
            -1, 1, // Top left
            0, -1, // bottom
            0, 1, // top
            1, -1, // bottom right
            1, 0, // right
            1, 1 // top right
        };

        // add the neighbers in to a list
        for (int i = 0; i < points.length; i++) {
            int dx = points[i];
            int dy = points[++i];

            int newX = mine.x + dx;
            int newY = mine.y + dy;

            // if the coordinate is outside the range, filter it out
            if (newX >= 0 && newX < X_MINES
                    && newY >= 0 && newY < Y_MINES) {
                neighbors.add(grid[newX][newY]);
            }
        }

        return neighbors;
    }

    /**
     * Mine class.
     */
    private class Mine extends StackPane {
        private int x;
        private int y;
        private boolean hasBomb;
        private boolean isOpen = false;

        private Rectangle border = new Rectangle(MINE_SIZE - 4, MINE_SIZE - 4);
        private Text text = new Text();
        
        /**
         * Constructor of the mine.
         * @param x x coordinate
         * @param y y coordinate
         * @param hasBomb if the mine has a bomb
         */
        public Mine(int x, int y, boolean hasBomb) {
            this.x = x;
            this.y = y;
            this.hasBomb = hasBomb;

            // The Mine should appear to be gray before open
            this.border.setFill(Color.GRAY);
            this.border.setStroke(Color.LIGHTGRAY);

            this.text.setFont(Font.font(20));

            // If there is a bomb in mine, the letter B should be set inside the mine
            this.text.setText(hasBomb ? "B" : "");
            
            // The text should not be seen by user at the beginnng
            this.text.setVisible(false);

            this.getChildren().addAll(border, text);

            this.setTranslateX(x * MINE_SIZE);
            this.setTranslateY(y * MINE_SIZE);

            // Set the Mouseclick event when the mine is click
            this.setOnMouseClicked(e -> open());
        }

        /**
         * An open mine method.
         */
        public void open() {
            if (this.isOpen) {
                return; // if its already open, do nothing
            }

            if (this.hasBomb) {
                printLoss(); // print loss if the user click a bomb
                banner.setPreserveRatio(true);
                banner.setFitWidth(WIDTH);
                VBox vbox = new VBox(banner, notice, instructions, newGame());
                Pane root = new Pane(vbox);
                scene.setRoot(root); // reset scene and game
                return;
            }

            this.isOpen = true; // change the isOpen attribute to true
            this.text.setVisible(true); // reveal the mine
            this.border.setFill(null); // change color of the mine

            if (text.getText().isEmpty()) {
                // if the mine has no bombs in neighbors
                // open all mine until there is a mine in its neighbors
                getNeighbors(this).forEach(Mine::open);
            }

            if (isWon()) {
                // if all mine is reveal except the bombs
                // print win and restart the game
                printWin();
                banner.setPreserveRatio(true);
                banner.setFitWidth(WIDTH);
                VBox vbox = new VBox(banner, notice, instructions, newGame());
                Pane root = new Pane(vbox);
                scene.setRoot(root);
            }
        }

        /**
         * Method to check if the game is won already at each open.
         * @return true if the game is won
         */
        private boolean isWon() {
            for (int y = 0; y < Y_MINES; y++) {
                for (int x = 0; x < X_MINES; x++) {
                    Mine mine = grid[x][y];
    
                    if (mine.hasBomb) {
                        continue;
                    }
    
                    if (!mine.isOpen) {
                        return false;
                    }
                }
            }
            return true;
        }

        /**
         * Method to print the winning message.
         */
        private void printWin() {
            Runnable r = () -> {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setContentText("Congratulation!!\nYou have won!!!");
                alert.setWidth(200);
                alert.setHeight(200);
                alert.show();
            };
            Platform.runLater(r);
        }

        /**
         * Method to print the lossing message if loss.
         */
        private void printLoss() {
            Runnable r = () -> {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setContentText("You have opened up a mine!\nGame Over!");
                alert.setWidth(200);
                alert.setHeight(200);
                alert.show();
            };
            Platform.runLater(r);
        }

    }

    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(newGame());
        // setup scene
        banner.setPreserveRatio(true);
        banner.setFitWidth(WIDTH);
        VBox vbox = new VBox(banner, notice, instructions, newGame());
        Pane root = new Pane(vbox);
        scene = new Scene(root);
        
        // setup stage
        stage.setTitle("OmegaApp!");
        stage.setScene(scene);
        stage.setOnCloseRequest(event -> Platform.exit());
        stage.sizeToScene();
        stage.show();
    }

}