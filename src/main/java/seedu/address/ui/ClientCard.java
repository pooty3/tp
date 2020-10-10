//package seedu.address.ui;
//import javafx.fxml.FXML;
//import javafx.scene.control.Label;
//import javafx.scene.layout.FlowPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.Region;
//import seedu.address.model.person.client.Client;
//import seedu.address.ui.UiPart;
//
///**
// * An UI component that displays information of a {@code Client}.
// */
//public class ClientCard extends UiPart<Region> {
//
//    private static final String FXML = "ClientListCard.fxml";
//
//    /**
//     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
//     * As a consequence, UI elements' variable names cannot be set to such keywords
//     * or an exception will be thrown by JavaFX during runtime.
//     *
//     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on DocX level 4</a>
//     */
//
//    public final Client client;
//
//    @FXML
//    private HBox cardPane;
//    @FXML
//    private Label id;
//    @FXML
//    private Label name;
//    @FXML
//    private Label pid;
//    @FXML
//    private Label gender;
//    @FXML
//    private Label age;
//    @FXML
//    private Label phone;
//    @FXML
//    private Label address;
//    @FXML
//    private FlowPane tags;
//    @FXML
//    private Label appointmentStatus;
//
//    public ClientCard(Client client, int displayedIndex) {
//        super(FXML);
//        this.client = client;
//        id.setText(displayedIndex + ". ");
//        name.setText(client.getName().fullName);
//        pid.setText("| pid: " + client.getIdToString());
//        gender.setText(client.getGender().value);
//        phone.setText(client.getPhone().value);
//        address.setText(client.getAddress().value);
//
//        client.getTags().forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
//
//        //String appointmentStatusString = client.getAppointmentStatus().toString();
//        //appointmentStatus.setText(appointmentStatusString);
//
//    }
//
//    @Override
//    public boolean equals(Object other) {
//        // short circuit if same object
//        if (other == this) {
//            return true;
//        }
//
//        // instanceof handles nulls
//        if (!(other instanceof ClientCard)) {
//            return false;
//        }
//
//        // state check
//        ClientCard card = (ClientCard) other;
//        return id.getText().equals(card.id.getText())
//                && client.equals(card.client);
//    }
//}
