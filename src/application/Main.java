package application;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		Wheel wheel = new Wheel(1, 2);

		Text rules = new Text();
		rules.setText("To Play: Enter a number 1-10." + "\n" + "Press the start button to make the" + "\n"
				+ "wheel spin." + "\n");

		Button startButton = new Button("Click to Start Game");

		Label guessLabel = new Label("Enter Guess (1-10)");
		Label numberLabel = new Label("The Wheel Landed on:");
		Label winLoseLabel = new Label("How Did You Do?");
		Label cashPrizeLabel = new Label("Cash Prize:");

		TextField guessField = new TextField();
		TextField numberField = new TextField();
		TextField winLoseField = new TextField();
		TextField cashPrizeField = new TextField();

		Stage stage = new Stage();

		FlowPane pane = new FlowPane();
		Scene scene = new Scene(pane, 220, 300);

		pane.getChildren().addAll(rules, guessLabel, guessField, startButton, numberLabel, numberField, winLoseField,
				cashPrizeLabel, cashPrizeField);
		primaryStage.setScene(scene);
		stage.show();

		primaryStage.setScene(scene);
		primaryStage.setTitle("Wheel Roulette");
		primaryStage.show();

		startButton.setOnAction(e -> {
			guessField.setDisable(false);
			PauseTransition pause = new PauseTransition(Duration.seconds(10));
			pause.setOnFinished(ev -> {
				guessField.setDisable(true);
			});
			pause.play();
		});

		HashMap<String, String> hashmap = new HashMap<String, String>();

		hashmap.put("1", "$10,000");
		hashmap.put("2", "$10,000");
		hashmap.put("3", "$10,000");
		hashmap.put("4", "$10,000");
		hashmap.put("5", "$10,000");
		hashmap.put("6", "$10,000");
		hashmap.put("7", "$10,000");
		hashmap.put("8", "$10,000");
		hashmap.put("9", "$10,000");
		hashmap.put("10", "$10,000");

		Set set = hashmap.entrySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
		}

		startButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				wheel.run();

				guessField.setEditable(true);
				System.out.println(guessField.getText());

				int intWheelPosition = Wheel.getPosition();
				String wheelPosition;

				wheelPosition = Integer.toString(intWheelPosition);
				numberField.setText(wheelPosition);

				int guess = Integer.parseInt(guessField.getText());

				if (guess != Wheel.getPosition()) {
					winLoseField.setText("Sorry, you lose!");
					cashPrizeField.setText("$0");
				} else {
					winLoseField.setText("You Win!!!");

					if (guessField.getText() == numberLabel.getText()) {
						if (numberField.getText() == "1") {
							cashPrizeField.setText(hashmap.get(1));
						} else {
							if (numberField.getText() == "2") {
								cashPrizeField.setText(hashmap.get(2));
							} else {
								if (numberField.getText() == "3") {
									cashPrizeField.setText(hashmap.get(3));
								} else {
									if (numberField.getText() == "4") {
										cashPrizeField.setText(hashmap.get(4));
									} else {
										if (numberField.getText() == "5") {
											cashPrizeField.setText(hashmap.get(5));
										} else {
											if (numberField.getText() == "6") {
												cashPrizeField.setText(hashmap.get(6));
											} else {
												if (numberField.getText() == "7") {
													cashPrizeField.setText(hashmap.get(7));
												} else {
													if (numberField.getText() == "8") {
														cashPrizeField.setText(hashmap.get(8));
													} else {
														if (numberField.getText() == "9") {
															cashPrizeField.setText(hashmap.get(9));
														} else {
															if (numberField.getText() == "10") {
																cashPrizeField.setText(hashmap.get(10));
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		});

	}

	public static void main(String[] args) {
		launch(args);
	}
}
