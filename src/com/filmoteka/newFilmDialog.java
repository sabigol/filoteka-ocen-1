package com.filmoteka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.util.function.Function;

import static com.filmoteka.Film.*;

public class newFilmDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel namePanel;
    private JLabel nameLabel;
    public JTextField filmNameInput;
    private JPanel productionDatePanel;
    private JPanel ratePanel;
    private JLabel rateLabel;
    public JTextField productionDateInput;
    private JLabel productionDateLabel;
    private JPanel rateButtonsPanel;
    private JButton buttonOk;
    private JPanel actions;

    public Film newFilm;

    public newFilmDialog(Function<FilmItem, Boolean> addCallback) {

        //setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setSize(300, 300);
        //init

        JPanel contentPane = new JPanel();
        add(contentPane);

        // name

        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));
        contentPane.add(namePanel);

        JLabel nameLabel = new JLabel("Film name");
        nameLabel.setSize(nameLabel.getPreferredSize());
        namePanel.add(nameLabel);
        nameLabel.repaint();

        JTextField filmNameInput = new JTextField();
        namePanel.add(filmNameInput);

        // production date

        JPanel productionDatePanel = new JPanel();
        productionDatePanel.setLayout(new BoxLayout(productionDatePanel, BoxLayout.Y_AXIS));
        contentPane.add(productionDatePanel);

        JLabel productionDateLabel = new JLabel("Production date");
        productionDateLabel.validate();
        productionDatePanel.add(productionDateLabel);

        JTextField productionDateInput = new JTextField();
        productionDatePanel.add(productionDateInput);

        // rate

        JPanel ratePanel = new JPanel();
        ratePanel.setLayout(new BoxLayout(ratePanel, BoxLayout.Y_AXIS));
        contentPane.add(ratePanel);

        JLabel rateLabel = new JLabel("Rate film");
        rateLabel.validate();
        ratePanel.add(rateLabel);

        JPanel rateButtonsPanel = new JPanel();
        rateButtonsPanel.setLayout(new BoxLayout(rateButtonsPanel, BoxLayout.Y_AXIS));
        ratePanel.add(rateButtonsPanel);

        for (Rate rate : Rate.values()) {
            rateButtonsPanel.add(new JButton(rate.toString()));
            rateButtonsPanel.validate();
            rateButtonsPanel.repaint();
        }
        contentPane.repaint();

        // buttons

        JPanel actions = new JPanel();
        actions.setLayout(new BoxLayout(actions, BoxLayout.X_AXIS));
        contentPane.add(actions);

        JButton buttonOk = new JButton("Add");
        actions.add(buttonOk);

        JButton buttonCancel = new JButton("Cancel");
        actions.add(buttonCancel);

        //init props

        buttonOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK(filmNameInput.getText(), productionDateInput.getText());
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK(String name, String date) {
        if((name != null) && date.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})")) {
            try {
                newFilm = new FilmItem(name, date);
                addCallbackfilms.addFilm(newFilm);
                dispose();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        newFilmDialog dialog = new newFilmDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
