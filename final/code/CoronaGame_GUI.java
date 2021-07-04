/**
 * Our GUI class
 * View part of MVC architecture
 */

import javax.swing.*;
import java.awt.*;

public class CoronaGame_GUI implements PersonObserver {

    private ControllerInterface controller;
    private ModelInterface model;

    private MapInformations_Class mapInformations = new MapInformations_Class();


    private JPanel mainPanel;
    private JButton StartButton;
    private JButton stopButton;
    private JPanel MapPanel;
    private JTextPane information_TextPane;


    public CoronaGame_GUI(ControllerInterface controller, ModelInterface model){
        this.controller = controller;
        this.model = model;
        this.model.registerObserver(this);
    }

    /**
     * Create components of view and set window settings
     */
    public void CreateView(){
        JFrame frame = new JFrame("myApp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(this.mainPanel);
        this.mainPanel.setPreferredSize(new Dimension(1500,800));

        this.MapPanel.setPreferredSize(new Dimension(mapInformations.getMAP_WIDTH(),mapInformations.getMAP_HEIGHT()));
        this.MapPanel.setBackground(Color.black);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

    }

    /**
     * Create action listeners for start stop buttons
     */
    public void createControls(){
        StartButton.addActionListener(e -> this.controller.start_controller());
        stopButton.addActionListener(e -> this.controller.stop_controller());
    }

    /**
     * Update all individuals and reflect on the map.
     * Then print the individual's information on Textpane.
     */
    @Override
    public void updatePerson() {

        MediatorInterface mediator = model.getMediator();
        // Call PersonWalk method for all individuals.

        for(int i=0; i<mediator.getPeopleCount(); i++){
            mediator.PersonWalk(i);
        }

        Graphics g = MapPanel.getGraphics();
        MapPanel.paint(g); // Clear MapPanel
        // Draw individuals
        for(int i=0; i<mediator.getPeopleCount(); i++){
            mediator.DrawPerson(g,i);
        }
        // print the state counts and time passed
        this.model.printInformations(this.information_TextPane);

    }
}
