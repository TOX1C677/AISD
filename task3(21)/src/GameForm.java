import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameForm extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JButton buttonNewGame;
    private JButton buttonNextStep;
    private JPanel mainPane;
    private final GameWar game;

    public GameForm(){
        this.setContentPane(mainPane);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("War Game");
        this.pack();

        game = new GameWar();

        buttonNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.createNewGame();
                textField1.setText(game.firstToString());
                textField2.setText(game.secondToString());
            }
        });
        buttonNextStep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.nextStep();
                textField1.setText(game.firstToString());
                textField2.setText(game.secondToString());
            }
        });
    }
}
