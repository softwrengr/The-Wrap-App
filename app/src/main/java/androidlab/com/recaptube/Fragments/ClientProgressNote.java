package androidlab.com.recaptube.Fragments;

import android.app.DatePickerDialog;
import android.support.v4.app.Fragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import androidlab.com.recaptube.R;


public class ClientProgressNote extends Fragment implements View.OnClickListener {

    String homeCity, homeZip, homeState, homeStreet, schoolStreet, schoolCity, schoolZip, schoolState;
    Button button;
    SharedPreferences sharedPreferences;
    static SharedPreferences.Editor editor;
    String Code;
    final CharSequence[] items = {"brother", "caregiver", "father", "friend", "grandfather", "grandmother",
            "mother", "neighbor", "sister", "social worker", "teacher", "cancel"};
    TextView textPreviewIntroduction;
    LinearLayout linearLayoutAddress1, linearLayoutAddress2, linearLayoutPeoplePresentRow1,
            linearLayoutPeoplePresentRow2, linearLayoutPeoplePresentTeamRow;
    String clientId, clientName, task;
    Spinner spinnerAddress1, spinnerAddress2;
    EditText entryAddress1Street, entryAddress1City, entryAddress1State, entryAddress1Zip,
            entryAddress2Street, entryAddress2City, entryAddress2State, entryAddress2Zip;
    ToggleButton toggleButtonClient, toggleButtonFacilitator,
            toggleButtonTherapist, toggleButtonCFS, toggleButtonParentPartner, toggleButton12, toggleButton, toggleButton2, button4, button3, buttonAddPerson, toggleButton1122;
    ArrayList<String> list = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    int number = 0;
    int test = 0;
    private FloatingActionButton fab;
    String texteffectbutton;
    String buttonText1, buttonText2, buttonText3, buttonText4, buttonText5, buttonText6, buttonText7;
    String getBtn1, getBtn2, getBtn3, getBtn4, getBtn5, getBtn6, getBtn7;
    String indi = "an individual rehabilitation session with ";
    String allStaff = "an All Staff CFT with ";
    String CFT = "a CFT meeting with ";
    String ITC = "an ITC meeting with ";
    int teamMember = 1;
    int otherProfessional = 0;
    int familyMembers = 0;
    int friends = 0;
    String strDate;
    Double lat1, lng1, lat2, lng2;
    DatePickerDialog datePickerDialog;
    String getLatLngofAddress1, getLatLngofAddress2, latlngaddress1, latlngaddress2;
    String address1, address2;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_client_progress_note, container, false);

        sharedPreferences = getActivity().getSharedPreferences("recap", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        editor.putString("aaa", "").commit();
        editor.putString("bbb", "").commit();
        spinnerAddress1 = (Spinner) view.findViewById(R.id.spinnerAddress1);
        spinnerAddress2 = (Spinner) view.findViewById(R.id.spinnerAddress2);
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, list);
        clientId = sharedPreferences.getString("clientId", "");
        clientName = getArguments().getString("clientName");
        editor.putString("clientId", clientId).commit();
        task = getArguments().getString("task");
        customActionBar();
        list.add("Session Address");
        list.add(clientName + ": Home");
        list.add(clientName + ": School");
        list.add("Custom");
        list.add("SPA 2: Reseda");
        list.add("SPA 3: El Monte");
        list.add("SPA 4: LA Metro");
        list.add("SPA 6: Carson");
        list.add("SPA 6: Compton");
        list.add("SPA 7: Bellflower");
        list.add("SPA 8: Long Beach");
        list.add("SPA 8: Torrance");

        adapter.notifyDataSetChanged();
        spinnerAddress2.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        textPreviewIntroduction = (TextView) view.findViewById(R.id.textPreviewIntroduction);
        linearLayoutAddress1 = (LinearLayout) view.findViewById(R.id.linearLayoutAddress1);
        linearLayoutAddress2 = (LinearLayout) view.findViewById(R.id.linearLayoutAddress2);
        linearLayoutPeoplePresentRow1 = (LinearLayout) view.findViewById(R.id.linearLayoutPeoplePresentRow1);
        linearLayoutPeoplePresentRow2 = (LinearLayout) view.findViewById(R.id.linearLayoutPeoplePresentRow2);
        linearLayoutPeoplePresentTeamRow = (LinearLayout) view.findViewById(R.id.linearLayoutPeoplePresentTeamRow);

        entryAddress1State = (EditText) view.findViewById(R.id.entryAddress1State);
        entryAddress2State = (EditText) view.findViewById(R.id.entryAddress2State);
        entryAddress1Street = (EditText) view.findViewById(R.id.entryAddress1Street);
        entryAddress2Street = (EditText) view.findViewById(R.id.entryAddress2Street);
        entryAddress1City = (EditText) view.findViewById(R.id.entryAddress1City);
        entryAddress2City = (EditText) view.findViewById(R.id.entryAddress2City);
        entryAddress1Zip = (EditText) view.findViewById(R.id.entryAddress1Zip);
        entryAddress2Zip = (EditText) view.findViewById(R.id.entryAddress2Zip);
        toggleButtonClient = (ToggleButton) view.findViewById(R.id.toggleButtonClient);
        toggleButtonCFS = (ToggleButton) view.findViewById(R.id.toggleButtonCFS);
        toggleButtonFacilitator = (ToggleButton) view.findViewById(R.id.toggleButtonFacilitator);
        toggleButtonParentPartner = (ToggleButton) view.findViewById(R.id.toggleButtonParentPartner);
        toggleButtonTherapist = (ToggleButton) view.findViewById(R.id.toggleButtonTherapist);
        buttonAddPerson = (ToggleButton) view.findViewById(R.id.buttonAddPerson);
        toggleButton12 = (ToggleButton) view.findViewById(R.id.toggleButton12);
        toggleButton = (ToggleButton) view.findViewById(R.id.toggleButton);
        toggleButton1122 = (ToggleButton) view.findViewById(R.id.toggleButton1122);
        toggleButton2 = (ToggleButton) view.findViewById(R.id.toggleButton2);
        button4 = (ToggleButton) view.findViewById(R.id.button4);
        button3 = (ToggleButton) view.findViewById(R.id.button3);
        toggleButtonCFS.setChecked(true);

        getBtn1 = sharedPreferences.getString(clientId + " btn1", "");
        getBtn2 = sharedPreferences.getString(clientId + " btn2", "");
        getBtn3 = sharedPreferences.getString(clientId + " btn3", "");
        getBtn4 = sharedPreferences.getString(clientId + " btn4", "");
        getBtn5 = sharedPreferences.getString(clientId + " btn5", "");
        getBtn6 = sharedPreferences.getString(clientId + " btn6", "");
        getBtn7 = sharedPreferences.getString(clientId + " btn7", "");


        getCurrentTimeStamp();


        if (!getBtn1.equals("")) {
            buttonAddPerson.setVisibility(View.VISIBLE);
            buttonAddPerson.setTextOn(getBtn1);
            buttonAddPerson.setTextOff(getBtn1);
            buttonAddPerson.setText(getBtn1);
            number++;
        }
        if (!getBtn2.equals("")) {
            toggleButton12.setVisibility(View.VISIBLE);
            toggleButton12.setTextOn(getBtn2);
            toggleButton12.setTextOff(getBtn2);
            toggleButton12.setText(getBtn2);
            number++;
        }
        if (!getBtn3.equals("")) {
            toggleButton1122.setVisibility(View.VISIBLE);
            toggleButton1122.setTextOn(getBtn3);
            toggleButton1122.setTextOff(getBtn3);
            toggleButton1122.setText(getBtn3);
            number++;
        }
        if (!getBtn4.equals("")) {
            toggleButton.setVisibility(View.VISIBLE);
            toggleButton.setTextOn(getBtn4);
            toggleButton.setTextOff(getBtn4);
            toggleButton.setText(getBtn4);
            number++;

        }
        if (!getBtn5.equals("")) {
            toggleButton2.setVisibility(View.VISIBLE);
            toggleButton2.setTextOn(getBtn5);
            toggleButton2.setTextOff(getBtn5);
            toggleButton2.setText(getBtn5);
            number++;
        }
        if (!getBtn6.equals("")) {
            button4.setVisibility(View.VISIBLE);
            button4.setTextOn(getBtn6);
            button4.setTextOff(getBtn6);
            button4.setText(getBtn6);
            number++;
        }
        if (!getBtn7.equals("")) {
            button3.setVisibility(View.VISIBLE);
            button3.setTextOn(getBtn7);
            button3.setTextOff(getBtn7);
            button3.setText(getBtn7);
            number++;
        }

        toggleButtonClient.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    test++;
                    familyMembers++;
                    editor.putString("client", "yes").commit();
                    editor.putInt("fm", familyMembers).commit();
                    button.setVisibility(View.VISIBLE);
                    texteffectbutton = textPreviewIntroduction.getText().toString();
                    if (teamMember == 4 && otherProfessional + friends + familyMembers > 0) {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(ITC)) {
                            texteffectbutton = texteffectbutton.replace(ITC, allStaff);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonClient.getText() + ", ");
                        } else if (texteffectbutton.contains(allStaff)) {
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonClient.getText() + ", ");
                        } else {
                            textPreviewIntroduction.setText(texteffectbutton + allStaff + "the " + toggleButtonClient.getText() + ", ");
                        }
                    } else if (teamMember > 1 || otherProfessional > 0) {
                        if (texteffectbutton.contains(ITC)) {

                            if (texteffectbutton.contains(ITC)) {
                                texteffectbutton = texteffectbutton.replace(ITC, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonClient.getText() + ", ");
                            }
                        } else if (texteffectbutton.contains(indi)) {
                            texteffectbutton = texteffectbutton.replace(indi, CFT);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonClient.getText() + ", ");
                        } else if (texteffectbutton.contains(CFT)) {
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonClient.getText() + ", ");
                        } else {
                            textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + toggleButtonClient.getText() + ", ");
                        }

                    } else {
                        if (texteffectbutton.contains(ITC)) {
                            if (texteffectbutton.contains(ITC)) {
                                texteffectbutton = texteffectbutton.replace(ITC, indi);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonClient.getText() + ", ");
                            }

                        } else if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, indi);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonClient.getText() + ", ");
                        } else if (texteffectbutton.contains(indi)) {
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonClient.getText() + ", ");
                        } else {
                            textPreviewIntroduction.setText(texteffectbutton + indi + "the " + toggleButtonClient.getText() + ", ");
                        }
                    }

                } else {
                    familyMembers--;
                    String oldText = "the " + toggleButtonClient.getText().toString() + ", ";
                    String newText = "";
                    String returnedText = textPreviewIntroduction.getText().toString();
                    String temp = returnedText.replace(oldText, newText);
                    textPreviewIntroduction.setText(temp);
                    if (teamMember == 4 && friends + otherProfessional + familyMembers > 0) {
                        textPreviewIntroduction.setText(temp);
                    } else if (teamMember > 1 && familyMembers + otherProfessional + friends > 0) {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(CFT)) {
                            textPreviewIntroduction.setText(texteffectbutton);
                        } else if (texteffectbutton.contains(allStaff)) {
                            texteffectbutton = texteffectbutton.replace(allStaff, ITC);
                            textPreviewIntroduction.setText(texteffectbutton);
                        }
                    } else {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(allStaff)) {
                            texteffectbutton = texteffectbutton.replace(allStaff, ITC);
                            textPreviewIntroduction.setText(texteffectbutton);
                        } else if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, ITC);
                            textPreviewIntroduction.setText(texteffectbutton);
                        }

                    }
                }
            }
        });
        buttonAddPerson.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    test++;
                    button.setVisibility(View.VISIBLE);
                    texteffectbutton = textPreviewIntroduction.getText().toString();
                    if (buttonAddPerson.getText().toString().contains("teacher") || buttonAddPerson.getText().toString().contains("social worker")) {
                        otherProfessional++;
                    } else if (buttonAddPerson.getText().toString().contains("friend") || buttonAddPerson.getText().toString().contains("neighbor")) {
                        friends++;
                    } else {
                        familyMembers++;
                    }
                    if (teamMember == 4 && otherProfessional + friends + familyMembers > 0) {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(indi)) {
                            texteffectbutton = texteffectbutton.replace(indi, allStaff);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + buttonAddPerson.getText() + ", ");
                        } else if (texteffectbutton.contains(ITC)) {
                            texteffectbutton = texteffectbutton.replace(ITC, allStaff);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + buttonAddPerson.getText() + ", ");
                        } else if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, allStaff);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + buttonAddPerson.getText() + ", ");
                        } else {
                            if (texteffectbutton.contains(allStaff)) {
                                textPreviewIntroduction.setText(texteffectbutton + "the " + buttonAddPerson.getText() + ", ");
                            } else {
                                textPreviewIntroduction.setText(texteffectbutton + allStaff + "the " + buttonAddPerson.getText() + ", ");
                            }
                        }

                    } else if (teamMember > 1 || otherProfessional > 0) {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (buttonAddPerson.getText().toString().contains("social worker")) {
                            if (toggleButtonFacilitator.isChecked() && toggleButtonTherapist.isChecked() && toggleButtonParentPartner.isChecked()) {
                                if (texteffectbutton.contains(allStaff)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + buttonAddPerson.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + allStaff + "the " + buttonAddPerson.getText() + ", ");
                                }
                            } else if (texteffectbutton.contains(ITC)) {
                                texteffectbutton = texteffectbutton.replace(ITC, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + buttonAddPerson.getText() + ", ");
                            } else if (texteffectbutton.contains(indi)) {
                                texteffectbutton = texteffectbutton.replace(indi, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + buttonAddPerson.getText() + ", ");
                            } else {
                                if (texteffectbutton.contains(CFT)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + buttonAddPerson.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + buttonAddPerson.getText() + ", ");
                                }
                            }

                        } else if (buttonAddPerson.getText().toString().contains("teacher")) {
                            if (toggleButtonFacilitator.isChecked() && toggleButtonTherapist.isChecked() && toggleButtonParentPartner.isChecked()) {
                                if (texteffectbutton.contains(allStaff)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + buttonAddPerson.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + allStaff + "the " + buttonAddPerson.getText() + ", ");
                                }
                            } else if (texteffectbutton.contains(ITC)) {
                                texteffectbutton = texteffectbutton.replace(ITC, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + buttonAddPerson.getText() + ", ");
                            } else if (texteffectbutton.contains(indi)) {
                                texteffectbutton = texteffectbutton.replace(indi, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + buttonAddPerson.getText() + ", ");
                            } else {
                                if (texteffectbutton.contains(CFT)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + buttonAddPerson.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + buttonAddPerson.getText() + ", ");
                                }
                            }
                        } else {
                            if (texteffectbutton.contains(CFT)) {
                                if (texteffectbutton.contains(CFT)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + buttonAddPerson.getText() + ", ");
                                }
                            } else if (texteffectbutton.contains(ITC)) {
                                texteffectbutton = texteffectbutton.replace(ITC, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + buttonAddPerson.getText() + ", ");
                            } else if (texteffectbutton.contains(indi)) {
                                texteffectbutton = texteffectbutton.replace(indi, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + buttonAddPerson.getText() + ", ");
                            } else {
                                textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + buttonAddPerson.getText() + ", ");
                            }
                        }
                    } else {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(ITC)) {
                            texteffectbutton = texteffectbutton.replace(ITC, indi);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + buttonAddPerson.getText() + ", ");
                        } else if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, indi);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + buttonAddPerson.getText() + ", ");
                        } else if (texteffectbutton.contains(indi)) {
                            if (texteffectbutton.contains(indi)) {
                                textPreviewIntroduction.setText(texteffectbutton + "the " + buttonAddPerson.getText() + ", ");
                            }

                        } else {
                            textPreviewIntroduction.setText(texteffectbutton + indi + "the " + buttonAddPerson.getText() + ", ");
                        }
                    }

                } else {
                    if (buttonAddPerson.getText().toString().contains("teacher") || buttonAddPerson.getText().toString().contains("social worker")) {
                        otherProfessional--;
                    } else if (buttonAddPerson.getText().toString().contains("friend") || buttonAddPerson.getText().toString().contains("neighbor")) {
                        friends--;
                    } else {
                        familyMembers--;
                    }
                    String oldText = "the " + buttonAddPerson.getText().toString() + ", ";
                    String newText = "";
                    String returnedText = textPreviewIntroduction.getText().toString();
                    String temp = returnedText.replace(oldText, newText);
                    textPreviewIntroduction.setText(temp);
                    if (teamMember == 4 && friends + otherProfessional + familyMembers > 0) {
                        textPreviewIntroduction.setText(temp);
                    } else if (teamMember > 1 && familyMembers + friends + otherProfessional == 0) {
                        if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, ITC);
                            textPreviewIntroduction.setText(texteffectbutton);
                        } else if (texteffectbutton.contains(allStaff)) {
                            texteffectbutton = texteffectbutton.replace(allStaff, ITC);
                            textPreviewIntroduction.setText(texteffectbutton);
                        }
                    } else {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, indi);
                            textPreviewIntroduction.setText(texteffectbutton);
                        }
                        if (texteffectbutton.contains(ITC)) {
                            texteffectbutton = texteffectbutton.replace(ITC, indi);
                            textPreviewIntroduction.setText(texteffectbutton);
                        }
                    }

                }

            }

        });

        toggleButton12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    test++;
                    button.setVisibility(View.VISIBLE);
                    texteffectbutton = textPreviewIntroduction.getText().toString();
                    if (toggleButton12.getText().toString().contains("teacher") || toggleButton12.getText().toString().contains("social worker")) {

                        otherProfessional++;
                    } else if (toggleButton12.getText().toString().contains("friend") || toggleButton12.getText().toString().contains("neighbor")) {
                        friends++;
                    } else {
                        familyMembers++;
                    }
                    if (teamMember == 4 && otherProfessional + friends + familyMembers > 0) {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(indi)) {
                            texteffectbutton = texteffectbutton.replace(indi, allStaff);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton12.getText() + ", ");
                        } else if (texteffectbutton.contains(ITC)) {
                            texteffectbutton = texteffectbutton.replace(ITC, allStaff);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton12.getText() + ", ");
                        } else if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, allStaff);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton12.getText() + ", ");
                        } else {
                            if (texteffectbutton.contains(allStaff)) {
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton12.getText() + ", ");
                            } else {
                                textPreviewIntroduction.setText(texteffectbutton + allStaff + "the " + toggleButton12.getText() + ", ");
                            }
                        }

                    } else if (teamMember > 1 || otherProfessional > 0) {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (toggleButton12.getText().toString().contains("social worker")) {
                            if (toggleButtonFacilitator.isChecked() && toggleButtonTherapist.isChecked() && toggleButtonParentPartner.isChecked()) {
                                if (texteffectbutton.contains(allStaff)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton12.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + allStaff + "the " + toggleButton12.getText() + ", ");
                                }
                            } else if (texteffectbutton.contains(ITC)) {
                                texteffectbutton = texteffectbutton.replace(ITC, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton12.getText() + ", ");
                            } else if (texteffectbutton.contains(indi)) {
                                texteffectbutton = texteffectbutton.replace(indi, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton12.getText() + ", ");
                            } else {
                                if (texteffectbutton.contains(CFT)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton12.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + toggleButton12.getText() + ", ");
                                }
                            }

                        } else if (toggleButton12.getText().toString().contains("teacher")) {
                            if (toggleButtonFacilitator.isChecked() && toggleButtonTherapist.isChecked() && toggleButtonParentPartner.isChecked()) {
                                if (texteffectbutton.contains(allStaff)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton12.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + allStaff + "the " + toggleButton12.getText() + ", ");
                                }
                            } else if (texteffectbutton.contains(ITC)) {
                                texteffectbutton = texteffectbutton.replace(ITC, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton12.getText() + ", ");
                            } else if (texteffectbutton.contains(indi)) {
                                texteffectbutton = texteffectbutton.replace(indi, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton12.getText() + ", ");
                            } else {
                                if (texteffectbutton.contains(CFT)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton12.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + toggleButton12.getText() + ", ");
                                }
                            }
                        } else {
                            if (texteffectbutton.contains(CFT)) {
                                if (texteffectbutton.contains(CFT)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton12.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + toggleButton12.getText() + ", ");
                                }
                            } else if (texteffectbutton.contains(ITC)) {
                                texteffectbutton = texteffectbutton.replace(ITC, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton12.getText() + ", ");
                            } else if (texteffectbutton.contains(indi)) {
                                texteffectbutton = texteffectbutton.replace(indi, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton12.getText() + ", ");
                            } else {
                                textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + toggleButton12.getText() + ", ");
                            }
                        }

                    } else {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(ITC)) {
                            if (texteffectbutton.contains(ITC)) {
                                texteffectbutton = texteffectbutton.replace(ITC, indi);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton12.getText() + ", ");
                            }
                        } else if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, indi);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton12.getText() + ", ");
                        } else {

                            if (texteffectbutton.contains(indi)) {
                                texteffectbutton = textPreviewIntroduction.getText().toString();
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton12.getText() + ", ");
                            } else {
                                texteffectbutton = textPreviewIntroduction.getText().toString();
                                textPreviewIntroduction.setText(texteffectbutton + indi + "the " + toggleButton12.getText() + ", ");
                            }
                        }

                    }

                } else {
                    if (toggleButton12.getText().toString().contains("teacher") || toggleButton12.getText().toString().contains("social worker")) {
                        otherProfessional--;
                    } else if (toggleButton12.getText().toString().contains("friend") || toggleButton12.getText().toString().contains("neighbor")) {
                        friends--;
                    } else {
                        familyMembers--;
                    }
                    String oldText = "the " + toggleButton12.getText().toString() + ", ";
                    String newText = "";
                    String returnedText = textPreviewIntroduction.getText().toString();
                    String temp = returnedText.replace(oldText, newText);
                    textPreviewIntroduction.setText(temp);
                    if (teamMember == 4 && friends + otherProfessional + familyMembers > 0) {
                        textPreviewIntroduction.setText(temp);
                    } else if (teamMember > 1 && familyMembers + friends + otherProfessional == 0) {
                        if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, ITC);
                            textPreviewIntroduction.setText(texteffectbutton);
                        } else if (texteffectbutton.contains(allStaff)) {
                            texteffectbutton = texteffectbutton.replace(allStaff, ITC);
                            textPreviewIntroduction.setText(texteffectbutton);
                        }
                    } else {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, indi);
                            textPreviewIntroduction.setText(texteffectbutton);
                        }
                        if (texteffectbutton.contains(ITC)) {
                            texteffectbutton = texteffectbutton.replace(ITC, indi);
                            textPreviewIntroduction.setText(texteffectbutton);
                        }
                    }
                }
            }
        });

        toggleButton1122.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    test++;
                    button.setVisibility(View.VISIBLE);
                    texteffectbutton = textPreviewIntroduction.getText().toString();
                    if (toggleButton1122.getText().toString().contains("teacher") || toggleButton1122.getText().toString().contains("social worker")) {
                        otherProfessional++;
                    } else if (toggleButton1122.getText().toString().contains("friend") || toggleButton1122.getText().toString().contains("neighbor")) {
                        friends++;
                    } else {
                        familyMembers++;
                    }
                    if (teamMember == 4 && otherProfessional + friends + familyMembers > 0) {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(indi)) {
                            texteffectbutton = texteffectbutton.replace(indi, allStaff);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton1122.getText() + ", ");
                        } else if (texteffectbutton.contains(ITC)) {
                            texteffectbutton = texteffectbutton.replace(ITC, allStaff);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton1122.getText() + ", ");
                        } else if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, allStaff);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton1122.getText() + ", ");
                        } else {
                            if (texteffectbutton.contains(allStaff)) {
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton1122.getText() + ", ");
                            } else {
                                textPreviewIntroduction.setText(texteffectbutton + allStaff + "the " + toggleButton1122.getText() + ", ");
                            }
                        }

                    } else if (teamMember > 1 || otherProfessional > 0) {

                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (toggleButton1122.getText().toString().contains("social worker")) {
                            if (toggleButtonFacilitator.isChecked() && toggleButtonTherapist.isChecked() && toggleButtonParentPartner.isChecked()) {
                                if (texteffectbutton.contains(allStaff)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton1122.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + allStaff + "the " + toggleButton1122.getText() + ", ");
                                }
                            } else if (texteffectbutton.contains(ITC)) {
                                texteffectbutton = texteffectbutton.replace(ITC, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton1122.getText() + ", ");
                            } else if (texteffectbutton.contains(indi)) {
                                texteffectbutton = texteffectbutton.replace(indi, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton1122.getText() + ", ");
                            } else {
                                if (texteffectbutton.contains(CFT)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton1122.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + toggleButton1122.getText() + ", ");
                                }
                            }

                        } else if (toggleButton1122.getText().toString().contains("teacher")) {
                            if (toggleButtonFacilitator.isChecked() && toggleButtonTherapist.isChecked() && toggleButtonParentPartner.isChecked()) {
                                if (texteffectbutton.contains(allStaff)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton1122.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + allStaff + "the " + toggleButton1122.getText() + ", ");
                                }
                            } else if (texteffectbutton.contains(ITC)) {
                                texteffectbutton = texteffectbutton.replace(ITC, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton1122.getText() + ", ");
                            } else if (texteffectbutton.contains(indi)) {
                                texteffectbutton = texteffectbutton.replace(indi, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton1122.getText() + ", ");
                            } else {
                                if (texteffectbutton.contains(CFT)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton1122.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + toggleButton1122.getText() + ", ");
                                }
                            }
                        } else {
                            if (texteffectbutton.contains(CFT)) {
                                if (texteffectbutton.contains(CFT)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton1122.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + toggleButton1122.getText() + ", ");
                                }
                            } else if (texteffectbutton.contains(ITC)) {
                                texteffectbutton = texteffectbutton.replace(ITC, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton1122.getText() + ", ");
                            } else if (texteffectbutton.contains(indi)) {
                                texteffectbutton = texteffectbutton.replace(indi, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton1122.getText() + ", ");
                            } else {
                                textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + toggleButton1122.getText() + ", ");
                            }
                        }

                    } else {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(ITC)) {
                            if (texteffectbutton.contains(ITC)) {
                                texteffectbutton = texteffectbutton.replace(ITC, indi);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton1122.getText() + ", ");
                            }
                        } else if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, indi);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton1122.getText() + ", ");
                        } else if (texteffectbutton.contains(indi)) {
                            texteffectbutton = textPreviewIntroduction.getText().toString();
                            if (texteffectbutton.contains(indi)) {
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton1122.getText() + ", ");
                            } else {
                                textPreviewIntroduction.setText(texteffectbutton + indi + "the " + toggleButton1122.getText() + ", ");
                            }

                        } else {
                            textPreviewIntroduction.setText(texteffectbutton + indi + "the " + toggleButton1122.getText() + ", ");
                        }

                    }
                } else {
                    if (toggleButton1122.getText().toString().contains("teacher") || toggleButton1122.getText().toString().contains("social worker")) {
                        otherProfessional--;
                    } else if (toggleButton1122.getText().toString().contains("friend") || toggleButton1122.getText().toString().contains("neighbor")) {
                        friends--;
                    } else {
                        familyMembers--;
                    }
                    String oldText = "the " + toggleButton1122.getText().toString() + ", ";
                    String newText = "";
                    String returnedText = textPreviewIntroduction.getText().toString();
                    String temp = returnedText.replace(oldText, newText);
                    textPreviewIntroduction.setText(temp);
                    if (teamMember == 4 && friends + otherProfessional + familyMembers > 0) {
                        textPreviewIntroduction.setText(temp);
                    } else if (teamMember > 1 && familyMembers + friends + otherProfessional == 0) {
                        if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, ITC);
                            textPreviewIntroduction.setText(texteffectbutton);
                        } else if (texteffectbutton.contains(allStaff)) {
                            texteffectbutton = texteffectbutton.replace(allStaff, ITC);
                            textPreviewIntroduction.setText(texteffectbutton);
                        }
                    } else {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, indi);
                            textPreviewIntroduction.setText(texteffectbutton);
                        }
                        if (texteffectbutton.contains(ITC)) {
                            texteffectbutton = texteffectbutton.replace(ITC, indi);
                            textPreviewIntroduction.setText(texteffectbutton);
                        }
                    }
                }
            }
        });
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    test++;
                    button.setVisibility(View.VISIBLE);
                    texteffectbutton = textPreviewIntroduction.getText().toString();
                    if (toggleButton.getText().toString().contains("teacher") || toggleButton.getText().toString().contains("social worker")) {
                        otherProfessional++;
                    } else if (toggleButton.getText().toString().contains("friend") || toggleButton.getText().toString().contains("neighbor")) {
                        friends++;
                    } else {
                        familyMembers++;
                    }
                    if (teamMember == 4 && otherProfessional + friends + familyMembers > 0) {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(indi)) {
                            texteffectbutton = texteffectbutton.replace(indi, allStaff);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton.getText() + ", ");
                        } else if (texteffectbutton.contains(ITC)) {
                            texteffectbutton = texteffectbutton.replace(ITC, allStaff);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton.getText() + ", ");
                        } else if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, allStaff);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton.getText() + ", ");
                        } else {
                            if (texteffectbutton.contains(allStaff)) {
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton.getText() + ", ");
                            } else {
                                textPreviewIntroduction.setText(texteffectbutton + allStaff + "the " + toggleButton.getText() + ", ");
                            }
                        }

                    } else if (teamMember > 1 || otherProfessional > 0) {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (toggleButton.getText().toString().contains("social worker")) {
                            if (toggleButtonFacilitator.isChecked() && toggleButtonTherapist.isChecked() && toggleButtonParentPartner.isChecked()) {
                                if (texteffectbutton.contains(allStaff)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + allStaff + "the " + toggleButton.getText() + ", ");
                                }
                            } else if (texteffectbutton.contains(ITC)) {
                                texteffectbutton = texteffectbutton.replace(ITC, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton.getText() + ", ");
                            } else if (texteffectbutton.contains(indi)) {
                                texteffectbutton = texteffectbutton.replace(indi, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton.getText() + ", ");
                            } else {
                                if (texteffectbutton.contains(CFT)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + toggleButton.getText() + ", ");
                                }
                            }

                        } else if (toggleButton.getText().toString().contains("teacher")) {
                            if (toggleButtonFacilitator.isChecked() && toggleButtonTherapist.isChecked() && toggleButtonParentPartner.isChecked()) {
                                if (texteffectbutton.contains(allStaff)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + allStaff + "the " + toggleButton.getText() + ", ");
                                }
                            } else if (texteffectbutton.contains(ITC)) {
                                texteffectbutton = texteffectbutton.replace(ITC, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton.getText() + ", ");
                            } else if (texteffectbutton.contains(indi)) {
                                texteffectbutton = texteffectbutton.replace(indi, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton.getText() + ", ");
                            } else {
                                if (texteffectbutton.contains(CFT)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + toggleButton.getText() + ", ");
                                }
                            }
                        } else {
                            if (texteffectbutton.contains(CFT)) {
                                if (texteffectbutton.contains(CFT)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + toggleButton.getText() + ", ");
                                }
                            } else if (texteffectbutton.contains(ITC)) {
                                texteffectbutton = texteffectbutton.replace(ITC, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton.getText() + ", ");
                            } else if (texteffectbutton.contains(indi)) {
                                texteffectbutton = texteffectbutton.replace(indi, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton.getText() + ", ");
                            } else {
                                textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + toggleButton.getText() + ", ");
                            }
                        }
                    } else {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(ITC)) {
                            if (texteffectbutton.contains(ITC)) {
                                texteffectbutton = texteffectbutton.replace(ITC, indi);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton.getText() + ", ");
                            }
                        } else if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(ITC, indi);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton.getText() + ", ");
                        } else {
                            if (texteffectbutton.contains(indi)) {
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton.getText() + ", ");
                            } else {
                                textPreviewIntroduction.setText(texteffectbutton + indi + "the " + toggleButton.getText() + ", ");
                            }
                        }

                    }
                } else {
                    if (toggleButton.getText().toString().contains("teacher") || toggleButton.getText().toString().contains("social worker")) {
                        otherProfessional--;
                    } else if (toggleButton.getText().toString().contains("friend") || toggleButton.getText().toString().contains("neighbor")) {
                        friends--;
                    } else {
                        familyMembers--;
                    }
                    String oldText = "the " + toggleButton.getText().toString() + ", ";
                    String newText = "";
                    String returnedText = textPreviewIntroduction.getText().toString();
                    String temp = returnedText.replace(oldText, newText);
                    textPreviewIntroduction.setText(temp);
                    if (teamMember == 4 && friends + otherProfessional + familyMembers > 0) {
                        textPreviewIntroduction.setText(temp);
                    } else if (teamMember > 1 && familyMembers + friends + otherProfessional == 0) {
                        if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, ITC);
                            textPreviewIntroduction.setText(texteffectbutton);
                        } else if (texteffectbutton.contains(allStaff)) {
                            texteffectbutton = texteffectbutton.replace(allStaff, ITC);
                            textPreviewIntroduction.setText(texteffectbutton);
                        }
                    } else {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, indi);
                            textPreviewIntroduction.setText(texteffectbutton);
                        }
                        if (texteffectbutton.contains(ITC)) {
                            texteffectbutton = texteffectbutton.replace(ITC, indi);
                            textPreviewIntroduction.setText(texteffectbutton);
                        }
                    }
                }
            }
        });
        toggleButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    test++;
                    button.setVisibility(View.VISIBLE);
                    texteffectbutton = textPreviewIntroduction.getText().toString();
                    if (toggleButton2.getText().toString().contains("teacher") || toggleButton2.getText().toString().contains("social worker")) {

                        otherProfessional++;
                    } else if (toggleButton2.getText().toString().contains("friend") || toggleButton2.getText().toString().contains("neighbor")) {
                        friends++;
                    } else {
                        familyMembers++;
                    }
                    if (teamMember == 4 && otherProfessional + friends + familyMembers > 0) {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(indi)) {
                            texteffectbutton = texteffectbutton.replace(indi, allStaff);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton2.getText() + ", ");
                        } else if (texteffectbutton.contains(ITC)) {
                            texteffectbutton = texteffectbutton.replace(ITC, allStaff);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton2.getText() + ", ");
                        } else if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, allStaff);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton2.getText() + ", ");
                        } else {
                            if (texteffectbutton.contains(allStaff)) {
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton2.getText() + ", ");
                            } else {
                                textPreviewIntroduction.setText(texteffectbutton + allStaff + "the " + toggleButton2.getText() + ", ");
                            }
                        }

                    } else if (teamMember > 1 || otherProfessional > 0) {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (toggleButton2.getText().toString().contains("social worker")) {
                            if (toggleButtonFacilitator.isChecked() && toggleButtonTherapist.isChecked() && toggleButtonParentPartner.isChecked()) {
                                if (texteffectbutton.contains(allStaff)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton2.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + allStaff + "the " + toggleButton2.getText() + ", ");
                                }
                            } else if (texteffectbutton.contains(ITC)) {
                                texteffectbutton = texteffectbutton.replace(ITC, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton2.getText() + ", ");
                            } else if (texteffectbutton.contains(indi)) {
                                texteffectbutton = texteffectbutton.replace(indi, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton2.getText() + ", ");
                            } else {
                                if (texteffectbutton.contains(CFT)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton2.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + toggleButton2.getText() + ", ");
                                }
                            }

                        } else if (toggleButton2.getText().toString().contains("teacher")) {
                            if (toggleButtonFacilitator.isChecked() && toggleButtonTherapist.isChecked() && toggleButtonParentPartner.isChecked()) {
                                if (texteffectbutton.contains(allStaff)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton2.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + allStaff + "the " + toggleButton2.getText() + ", ");
                                }
                            } else if (texteffectbutton.contains(ITC)) {
                                texteffectbutton = texteffectbutton.replace(ITC, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton2.getText() + ", ");
                            } else if (texteffectbutton.contains(indi)) {
                                texteffectbutton = texteffectbutton.replace(indi, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton2.getText() + ", ");
                            } else {
                                if (texteffectbutton.contains(CFT)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton2.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + toggleButton2.getText() + ", ");
                                }
                            }
                        } else {
                            if (texteffectbutton.contains(CFT)) {
                                if (texteffectbutton.contains(CFT)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton2.getText() + ", ");
                                }
                            } else if (texteffectbutton.contains(ITC)) {
                                if (texteffectbutton.contains(ITC)) {
                                    texteffectbutton = texteffectbutton.replace(ITC, CFT);
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton2.getText() + ", ");
                                }
                            } else if (texteffectbutton.contains(indi)) {
                                if (texteffectbutton.contains(indi)) {
                                    texteffectbutton = texteffectbutton.replace(indi, CFT);
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton2.getText() + ", ");
                                }

                            } else {
                                textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + toggleButton2.getText() + ", ");
                            }
                        }

                    } else {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(ITC)) {
                            if (texteffectbutton.contains(ITC)) {
                                texteffectbutton = texteffectbutton.replace(ITC, indi);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton2.getText() + ", ");
                            }
                        } else if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, indi);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton2.getText() + ", ");
                        } else if (texteffectbutton.contains(indi)) {
                            texteffectbutton = textPreviewIntroduction.getText().toString();
                            if (texteffectbutton.contains(indi)) {
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButton2.getText() + ", ");
                            }
                        } else {
                            texteffectbutton = textPreviewIntroduction.getText().toString();
                            textPreviewIntroduction.setText(texteffectbutton + indi + "the " + toggleButton2.getText() + ", ");
                        }

                    }

                } else {
                    if (toggleButton2.getText().toString().contains("teacher") || toggleButton2.getText().toString().contains("social worker")) {
                        otherProfessional--;
                    } else if (toggleButton2.getText().toString().contains("friend") || toggleButton2.getText().toString().contains("neighbor")) {
                        friends--;
                    } else {
                        familyMembers--;
                    }
                    String oldText = "the " + toggleButton2.getText().toString() + ", ";
                    String newText = "";
                    String returnedText = textPreviewIntroduction.getText().toString();
                    String temp = returnedText.replace(oldText, newText);
                    textPreviewIntroduction.setText(temp);
                    if (teamMember == 4 && friends + otherProfessional + familyMembers > 0) {
                        textPreviewIntroduction.setText(temp);
                    } else if (teamMember > 1 && familyMembers + friends + otherProfessional == 0) {
                        if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, ITC);
                            textPreviewIntroduction.setText(texteffectbutton);
                        } else if (texteffectbutton.contains(allStaff)) {
                            texteffectbutton = texteffectbutton.replace(allStaff, ITC);
                            textPreviewIntroduction.setText(texteffectbutton);
                        }
                    } else {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, indi);
                            textPreviewIntroduction.setText(texteffectbutton);
                        }
                        if (texteffectbutton.contains(ITC)) {
                            texteffectbutton = texteffectbutton.replace(ITC, indi);
                            textPreviewIntroduction.setText(texteffectbutton);
                        }
                    }
                }
            }
        });
        button4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    test++;
                    button.setVisibility(View.VISIBLE);
                    texteffectbutton = textPreviewIntroduction.getText().toString();
                    if (button4.getText().toString().contains("teacher") || button4.getText().toString().contains("social worker")) {
                        otherProfessional++;
                    } else if (button4.getText().toString().contains("friend") || button4.getText().toString().contains("neighbor")) {
                        friends++;
                    } else {
                        familyMembers++;
                    }
                    if (teamMember == 4 && otherProfessional + friends + familyMembers > 0) {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(indi)) {
                            texteffectbutton = texteffectbutton.replace(indi, allStaff);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + button4.getText() + ", ");
                        } else if (texteffectbutton.contains(ITC)) {
                            texteffectbutton = texteffectbutton.replace(ITC, allStaff);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + button4.getText() + ", ");
                        } else if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, allStaff);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + button4.getText() + ", ");
                        } else {
                            if (texteffectbutton.contains(allStaff)) {
                                textPreviewIntroduction.setText(texteffectbutton + "the " + button4.getText() + ", ");
                            } else {
                                textPreviewIntroduction.setText(texteffectbutton + allStaff + "the " + button4.getText() + ", ");
                            }
                        }

                    } else if (teamMember > 1 || otherProfessional > 0) {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (button4.getText().toString().contains("social worker")) {
                            if (toggleButtonFacilitator.isChecked() && toggleButtonTherapist.isChecked() && toggleButtonParentPartner.isChecked()) {
                                if (texteffectbutton.contains(allStaff)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + button4.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + allStaff + "the " + button4.getText() + ", ");
                                }
                            } else if (texteffectbutton.contains(ITC)) {
                                texteffectbutton = texteffectbutton.replace(ITC, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + button4.getText() + ", ");
                            } else if (texteffectbutton.contains(indi)) {
                                texteffectbutton = texteffectbutton.replace(indi, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + button4.getText() + ", ");
                            } else {
                                if (texteffectbutton.contains(CFT)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + button4.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + button4.getText() + ", ");
                                }
                            }

                        } else if (button4.getText().toString().contains("teacher")) {
                            if (toggleButtonFacilitator.isChecked() && toggleButtonTherapist.isChecked() && toggleButtonParentPartner.isChecked()) {
                                if (texteffectbutton.contains(allStaff)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + button4.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + allStaff + "the " + button4.getText() + ", ");
                                }
                            } else if (texteffectbutton.contains(ITC)) {
                                texteffectbutton = texteffectbutton.replace(ITC, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + button4.getText() + ", ");
                            } else if (texteffectbutton.contains(indi)) {
                                texteffectbutton = texteffectbutton.replace(indi, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + button4.getText() + ", ");
                            } else {
                                if (texteffectbutton.contains(CFT)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + button4.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + button4.getText() + ", ");
                                }
                            }
                        } else {
                            if (texteffectbutton.contains(CFT)) {
                                if (texteffectbutton.contains(CFT)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + button4.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + button4.getText() + ", ");
                                }
                            } else if (texteffectbutton.contains(ITC)) {
                                texteffectbutton = texteffectbutton.replace(ITC, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + button4.getText() + ", ");
                            } else if (texteffectbutton.contains(indi)) {
                                texteffectbutton = texteffectbutton.replace(indi, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + button4.getText() + ", ");
                            } else {
                                textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + button4.getText() + ", ");
                            }
                        }

                    } else {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(ITC)) {
                            texteffectbutton = texteffectbutton.replace(ITC, indi);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + button4.getText() + ", ");
                        } else if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, indi);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + button4.getText() + ", ");
                        } else if (texteffectbutton.contains(indi)) {
                            texteffectbutton = textPreviewIntroduction.getText().toString();
                            if (texteffectbutton.contains(indi)) {
                                textPreviewIntroduction.setText(texteffectbutton + "the " + button4.getText() + ", ");
                            } else {
                                textPreviewIntroduction.setText(texteffectbutton + indi + "the " + button4.getText() + ", ");
                            }

                        } else {
                            texteffectbutton = textPreviewIntroduction.getText().toString();
                            textPreviewIntroduction.setText(texteffectbutton + indi + "the " + button4.getText() + ", ");
                        }


                    }

                } else {
                    if (button4.getText().toString().contains("teacher") || button4.getText().toString().contains("social worker")) {
                        otherProfessional--;
                    } else if (button4.getText().toString().contains("friend") || button4.getText().toString().contains("neighbor")) {
                        friends--;
                    } else {
                        familyMembers--;
                    }
                    String oldText = "the " + button4.getText().toString() + ", ";
                    String newText = "";
                    String returnedText = textPreviewIntroduction.getText().toString();
                    String temp = returnedText.replace(oldText, newText);
                    textPreviewIntroduction.setText(temp);
                    if (teamMember == 4 && friends + otherProfessional + familyMembers > 0) {
                        textPreviewIntroduction.setText(temp);
                    } else if (teamMember > 1 && familyMembers + friends + otherProfessional == 0) {
                        if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, ITC);
                            textPreviewIntroduction.setText(texteffectbutton);
                        } else if (texteffectbutton.contains(allStaff)) {
                            texteffectbutton = texteffectbutton.replace(allStaff, ITC);
                            textPreviewIntroduction.setText(texteffectbutton);
                        }
                    } else {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, indi);
                            textPreviewIntroduction.setText(texteffectbutton);
                        }
                        if (texteffectbutton.contains(ITC)) {
                            texteffectbutton = texteffectbutton.replace(ITC, indi);
                            textPreviewIntroduction.setText(texteffectbutton);
                        }
                    }
                }
            }
        });
        button3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    test++;
                    button.setVisibility(View.VISIBLE);
                    texteffectbutton = textPreviewIntroduction.getText().toString();
                    if (button3.getText().toString().contains("teacher") || button3.getText().toString().contains("social worker")) {

                        otherProfessional++;
                    } else if (button3.getText().toString().contains("friend") || button3.getText().toString().contains("neighbor")) {
                        friends++;
                    } else {
                        familyMembers++;
                    }
                    if (teamMember == 4 && otherProfessional + friends + familyMembers > 0) {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(indi)) {
                            texteffectbutton = texteffectbutton.replace(indi, allStaff);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + button3.getText() + ", ");
                        } else if (texteffectbutton.contains(ITC)) {
                            texteffectbutton = texteffectbutton.replace(ITC, allStaff);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + button3.getText() + ", ");
                        } else if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, allStaff);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + button3.getText() + ", ");
                        } else {
                            if (texteffectbutton.contains(allStaff)) {
                                textPreviewIntroduction.setText(texteffectbutton + "the " + button3.getText() + ", ");
                            } else {
                                textPreviewIntroduction.setText(texteffectbutton + allStaff + "the " + button3.getText() + ", ");
                            }
                        }

                    } else if (teamMember > 1 || otherProfessional > 0) {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (button3.getText().toString().contains("social worker")) {
                            if (toggleButtonFacilitator.isChecked() && toggleButtonTherapist.isChecked() && toggleButtonParentPartner.isChecked()) {
                                if (texteffectbutton.contains(allStaff)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + button3.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + allStaff + "the " + button3.getText() + ", ");
                                }
                            } else if (texteffectbutton.contains(ITC)) {
                                texteffectbutton = texteffectbutton.replace(ITC, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + button3.getText() + ", ");
                            } else if (texteffectbutton.contains(indi)) {
                                texteffectbutton = texteffectbutton.replace(indi, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + button3.getText() + ", ");
                            } else {
                                if (texteffectbutton.contains(CFT)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + button3.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + button3.getText() + ", ");
                                }
                            }

                        } else if (button3.getText().toString().contains("teacher")) {
                            if (toggleButtonFacilitator.isChecked() && toggleButtonTherapist.isChecked() && toggleButtonParentPartner.isChecked()) {
                                if (texteffectbutton.contains(allStaff)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + button3.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + allStaff + "the " + button3.getText() + ", ");
                                }
                            } else if (texteffectbutton.contains(ITC)) {
                                texteffectbutton = texteffectbutton.replace(ITC, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + button3.getText() + ", ");
                            } else if (texteffectbutton.contains(indi)) {
                                texteffectbutton = texteffectbutton.replace(indi, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + button3.getText() + ", ");
                            } else {
                                if (texteffectbutton.contains(CFT)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + button3.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + button3.getText() + ", ");
                                }
                            }
                        } else {
                            if (texteffectbutton.contains(CFT)) {
                                if (texteffectbutton.contains(CFT)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + button3.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + button3.getText() + ", ");
                                }
                            } else if (texteffectbutton.contains(ITC)) {
                                texteffectbutton = texteffectbutton.replace(ITC, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + button3.getText() + ", ");
                            } else if (texteffectbutton.contains(indi)) {
                                texteffectbutton = texteffectbutton.replace(indi, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + button3.getText() + ", ");
                            }
                        }

                    } else {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(ITC)) {
                            if (texteffectbutton.contains(ITC)) {
                                texteffectbutton = texteffectbutton.replace(ITC, indi);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + button3.getText() + ", ");
                            } else {
                                textPreviewIntroduction.setText(texteffectbutton + indi + "the " + button3.getText() + ", ");
                            }
                        } else if (texteffectbutton.contains(CFT)) {
                            if (texteffectbutton.contains(CFT)) {
                                texteffectbutton = texteffectbutton.replace(CFT, indi);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + button3.getText() + ", ");
                            } else {
                                textPreviewIntroduction.setText(texteffectbutton + indi + "the " + button3.getText() + ", ");
                            }
                        } else if (texteffectbutton.contains(indi)) {
                            texteffectbutton = textPreviewIntroduction.getText().toString();
                            if (texteffectbutton.contains(indi)) {
                                textPreviewIntroduction.setText(texteffectbutton + "the " + button3.getText() + ", ");
                            } else {
                                textPreviewIntroduction.setText(texteffectbutton + indi + "the " + button3.getText() + ", ");
                            }

                        } else {
                            texteffectbutton = textPreviewIntroduction.getText().toString();
                            textPreviewIntroduction.setText(texteffectbutton + indi + "the " + button3.getText() + ", ");
                        }


                    }

                } else {
                    if (button3.getText().toString().contains("teacher") || button3.getText().toString().contains("social worker")) {
                        otherProfessional--;
                    } else if (button3.getText().toString().contains("friend") || button3.getText().toString().contains("neighbor")) {
                        friends--;
                    } else {
                        familyMembers--;
                    }
                    String oldText = "the " + button3.getText().toString() + ", ";
                    String newText = "";
                    String returnedText = textPreviewIntroduction.getText().toString();
                    String temp = returnedText.replace(oldText, newText);
                    textPreviewIntroduction.setText(temp);
                    if (teamMember == 4 && friends + otherProfessional + familyMembers > 0) {
                        textPreviewIntroduction.setText(temp);
                    } else if (teamMember > 1 && familyMembers + friends + otherProfessional == 0) {
                        if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, ITC);
                            textPreviewIntroduction.setText(texteffectbutton);
                        } else if (texteffectbutton.contains(allStaff)) {
                            texteffectbutton = texteffectbutton.replace(allStaff, ITC);
                            textPreviewIntroduction.setText(texteffectbutton);
                        }
                    } else {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, indi);
                            textPreviewIntroduction.setText(texteffectbutton);
                        }
                        if (texteffectbutton.contains(ITC)) {
                            texteffectbutton = texteffectbutton.replace(ITC, indi);
                            textPreviewIntroduction.setText(texteffectbutton);
                        }
                    }
                }

            }

        });

        toggleButtonFacilitator.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    test++;
                    teamMember++;
                    button.setVisibility(View.VISIBLE);

                    if (teamMember > 1 && otherProfessional + friends + familyMembers == 0) {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(indi)) {
                            texteffectbutton = texteffectbutton.replace(indi, ITC);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonFacilitator.getText() + ", ");
                        } else if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, ITC);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonFacilitator.getText() + ", ");
                        } else if (texteffectbutton.contains(ITC)) {
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonFacilitator.getText() + ", ");
                        } else {
                            textPreviewIntroduction.setText(texteffectbutton + ITC + "the " + toggleButtonFacilitator.getText() + ", ");
                        }
                    } else if (teamMember == 4 && otherProfessional + friends + familyMembers > 0) {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(ITC)) {
                            texteffectbutton = texteffectbutton.replace(ITC, allStaff);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonFacilitator.getText() + ", ");
                        } else if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, allStaff);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonFacilitator.getText() + ", ");
                        } else if (texteffectbutton.contains(indi)) {
                            texteffectbutton = texteffectbutton.replace(indi, allStaff);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonFacilitator.getText() + ", ");
                        } else {

                            if (texteffectbutton.contains(allStaff)) {
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonFacilitator.getText() + ", ");
                            } else {
                                textPreviewIntroduction.setText(texteffectbutton + allStaff + "the " + toggleButtonFacilitator.getText() + ", ");
                            }
                        }

                    } else if (teamMember > 1 || otherProfessional > 1) {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (toggleButtonFacilitator.getText().toString().contains("social worker")) {

                            if (texteffectbutton.contains(CFT)) {
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonFacilitator.getText() + ", ");
                            } else {
                                textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + toggleButtonFacilitator.getText() + ", ");
                            }
                        } else if (toggleButtonFacilitator.getText().toString().contains("teacher")) {
                            if (texteffectbutton.contains(CFT)) {
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonFacilitator.getText() + ", ");
                            } else {
                                textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + toggleButtonFacilitator.getText() + ", ");
                            }
                        } else {
                            if (texteffectbutton.contains(indi)) {
                                texteffectbutton = texteffectbutton.replace(indi, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonFacilitator.getText() + ", ");
                            } else {
                                textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + toggleButtonFacilitator.getText() + ", ");
                            }
                            if (texteffectbutton.contains(CFT)) {
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonFacilitator.getText() + ", ");
                            } else {
                                textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + toggleButtonFacilitator.getText() + ", ");
                            }
                        }

                    } else {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, ITC);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonFacilitator.getText() + ", ");
                        } else if (texteffectbutton.contains(allStaff)) {
                            texteffectbutton = texteffectbutton.replace(allStaff, ITC);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonFacilitator.getText() + ", ");
                        } else if (texteffectbutton.contains(indi)) {
                            texteffectbutton = texteffectbutton.replace(indi, ITC);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonFacilitator.getText() + ", ");
                        } else {
                            textPreviewIntroduction.setText(texteffectbutton + ITC + "the " + toggleButtonFacilitator.getText() + ", ");
                        }

                    }
                } else {
                    teamMember--;
                    String oldText = "the " + toggleButtonFacilitator.getText().toString() + ", ";
                    String newText = "";
                    String returnedText = textPreviewIntroduction.getText().toString();
                    String temp = returnedText.replace(oldText, newText);
                    textPreviewIntroduction.setText(temp);
                    if (temp.contains(CFT)) {
                        if (otherProfessional > 0) {
                            textPreviewIntroduction.setText(temp);
                        } else if (teamMember == 1) {
                            String finalText = temp.replace(CFT, indi);
                            textPreviewIntroduction.setText(finalText);
                        }

                    } else if (temp.contains(allStaff)) {
                        if (!toggleButtonFacilitator.isChecked() || !toggleButtonTherapist.isChecked()
                                || !toggleButtonParentPartner.isChecked()) {
                            String finalText = temp.replace(allStaff, CFT);
                            textPreviewIntroduction.setText(finalText);
                        }
                    }

                }
            }
        });

        toggleButtonTherapist.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    test++;
                    teamMember++;
                    button.setVisibility(View.VISIBLE);
                    if (teamMember > 1 && otherProfessional + friends + familyMembers == 0) {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(indi)) {
                            texteffectbutton = texteffectbutton.replace(indi, ITC);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonTherapist.getText() + ", ");
                        } else if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, ITC);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonTherapist.getText() + ", ");
                        } else if (texteffectbutton.contains(ITC)) {
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonTherapist.getText() + ", ");
                        } else {
                            textPreviewIntroduction.setText(texteffectbutton + ITC + "the " + toggleButtonTherapist.getText() + ", ");
                        }
                    } else if (teamMember == 4 && otherProfessional + friends + familyMembers > 0) {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(ITC)) {
                            texteffectbutton = texteffectbutton.replace(ITC, allStaff);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonTherapist.getText() + ", ");
                        } else if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, allStaff);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonTherapist.getText() + ", ");
                        } else if (texteffectbutton.contains(indi)) {
                            texteffectbutton = texteffectbutton.replace(indi, allStaff);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonTherapist.getText() + ", ");
                        } else {

                            if (texteffectbutton.contains(allStaff)) {
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonTherapist.getText() + ", ");
                            } else {
                                textPreviewIntroduction.setText(texteffectbutton + allStaff + "the " + toggleButtonTherapist.getText() + ", ");
                            }
                        }

                    } else if (teamMember > 1 || otherProfessional > 1) {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (toggleButtonTherapist.getText().toString().contains("social worker")) {

                            if (texteffectbutton.contains(CFT)) {
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonTherapist.getText() + ", ");
                            } else {
                                textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + toggleButtonTherapist.getText() + ", ");
                            }
                        } else if (toggleButtonTherapist.getText().toString().contains("teacher")) {
                            if (texteffectbutton.contains(CFT)) {
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonTherapist.getText() + ", ");
                            } else {
                                textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + toggleButtonTherapist.getText() + ", ");
                            }
                        } else {
                            if (texteffectbutton.contains(indi)) {
                                texteffectbutton = texteffectbutton.replace(indi, CFT);
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonTherapist.getText() + ", ");
                            } else {
                                textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + toggleButtonTherapist.getText() + ", ");
                            }
                            if (texteffectbutton.contains(CFT)) {
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonTherapist.getText() + ", ");
                            } else {
                                textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + toggleButtonTherapist.getText() + ", ");
                            }
                        }

                    } else {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, ITC);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonTherapist.getText() + ", ");
                        } else if (texteffectbutton.contains(allStaff)) {
                            texteffectbutton = texteffectbutton.replace(allStaff, ITC);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonTherapist.getText() + ", ");
                        } else if (texteffectbutton.contains(indi)) {
                            texteffectbutton = texteffectbutton.replace(indi, ITC);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonTherapist.getText() + ", ");
                        } else {
                            textPreviewIntroduction.setText(texteffectbutton + ITC + "the " + toggleButtonTherapist.getText() + ", ");
                        }

                    }
                } else {
                    teamMember--;
                    String oldText = "the " + toggleButtonTherapist.getText().toString() + ", ";
                    String newText = "";
                    String returnedText = textPreviewIntroduction.getText().toString();
                    String temp = returnedText.replace(oldText, newText);
                    textPreviewIntroduction.setText(temp);
                    if (temp.contains(CFT)) {
                        if (otherProfessional > 0) {
                            textPreviewIntroduction.setText(temp);
                        } else if (teamMember == 1) {
                            String finalText = temp.replace(CFT, indi);
                            textPreviewIntroduction.setText(finalText);
                        }
                    } else if (temp.contains(allStaff)) {
                        if (!toggleButtonFacilitator.isChecked() || !toggleButtonTherapist.isChecked()
                                || !toggleButtonParentPartner.isChecked()) {
                            String finalText = temp.replace(allStaff, CFT);
                            textPreviewIntroduction.setText(finalText);
                        }
                    }
                }
            }
        });

        toggleButtonCFS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggleButtonCFS.setChecked(true);
                } else {
                    toggleButtonCFS.setChecked(true);
                }
            }
        });

        toggleButtonParentPartner.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    test++;
                    teamMember++;
                    button.setVisibility(View.VISIBLE);
                    if (teamMember > 1 && otherProfessional + friends + familyMembers == 0) {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(indi)) {
                            texteffectbutton = texteffectbutton.replace(indi, ITC);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonParentPartner.getText() + ", ");
                        } else if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, ITC);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonParentPartner.getText() + ", ");
                        } else if (texteffectbutton.contains(ITC)) {
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonParentPartner.getText() + ", ");
                        } else {
                            textPreviewIntroduction.setText(texteffectbutton + ITC + "the " + toggleButtonParentPartner.getText() + ", ");
                        }
                    } else if (teamMember == 4 && otherProfessional + friends + familyMembers > 0) {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(ITC)) {
                            texteffectbutton = texteffectbutton.replace(ITC, allStaff);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonParentPartner.getText() + ", ");
                        } else if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, allStaff);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonParentPartner.getText() + ", ");
                        } else if (texteffectbutton.contains(indi)) {
                            texteffectbutton = texteffectbutton.replace(indi, allStaff);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonParentPartner.getText() + ", ");
                        } else {

                            if (texteffectbutton.contains(allStaff)) {
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonParentPartner.getText() + ", ");
                            } else {
                                textPreviewIntroduction.setText(texteffectbutton + allStaff + "the " + toggleButtonParentPartner.getText() + ", ");
                            }
                        }

                    } else if (teamMember > 1 || otherProfessional > 1) {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (toggleButtonParentPartner.getText().toString().contains("social worker")) {

                            if (texteffectbutton.contains(CFT)) {
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonParentPartner.getText() + ", ");
                            } else {
                                textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + toggleButtonParentPartner.getText() + ", ");
                            }
                        } else if (toggleButtonParentPartner.getText().toString().contains("teacher")) {
                            if (texteffectbutton.contains(CFT)) {
                                textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonParentPartner.getText() + ", ");
                            } else {
                                textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + toggleButtonParentPartner.getText() + ", ");
                            }
                        } else {
                            if (texteffectbutton.contains(indi)) {
                                if (texteffectbutton.contains(indi)) {
                                    texteffectbutton = texteffectbutton.replace(indi, CFT);
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonParentPartner.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + toggleButtonParentPartner.getText() + ", ");
                                }
                            } else if (texteffectbutton.contains(ITC)) {
                                if (texteffectbutton.contains(ITC)) {
                                    texteffectbutton = texteffectbutton.replace(ITC, CFT);
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonParentPartner.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + toggleButtonParentPartner.getText() + ", ");
                                }
                            }
                            if (texteffectbutton.contains(CFT)) {
                                if (texteffectbutton.contains(CFT)) {
                                    textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonParentPartner.getText() + ", ");
                                } else {
                                    textPreviewIntroduction.setText(texteffectbutton + CFT + "the " + toggleButtonParentPartner.getText() + ", ");
                                }
                            }

                        }

                    } else {
                        texteffectbutton = textPreviewIntroduction.getText().toString();
                        if (texteffectbutton.contains(CFT)) {
                            texteffectbutton = texteffectbutton.replace(CFT, ITC);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonParentPartner.getText() + ", ");
                        } else if (texteffectbutton.contains(allStaff)) {
                            texteffectbutton = texteffectbutton.replace(allStaff, ITC);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonParentPartner.getText() + ", ");
                        } else if (texteffectbutton.contains(indi)) {
                            texteffectbutton = texteffectbutton.replace(indi, ITC);
                            textPreviewIntroduction.setText(texteffectbutton + "the " + toggleButtonParentPartner.getText() + ", ");
                        } else {
                            textPreviewIntroduction.setText(texteffectbutton + ITC + "the " + toggleButtonParentPartner.getText() + ", ");
                        }

                    }
                } else {
                    teamMember--;
                    String oldText = "the " + toggleButtonParentPartner.getText().toString() + ", ";
                    String newText = "";
                    String returnedText = textPreviewIntroduction.getText().toString();
                    String temp = returnedText.replace(oldText, newText);
                    textPreviewIntroduction.setText(temp);
                    if (temp.contains(CFT)) {
                        if (otherProfessional > 0) {
                            textPreviewIntroduction.setText(temp);
                        } else if (teamMember == 1) {
                            String finalText = temp.replace(CFT, indi);
                            textPreviewIntroduction.setText(finalText);
                        }
                    } else if (temp.contains(allStaff)) {
                        if (!toggleButtonFacilitator.isChecked() || !toggleButtonTherapist.isChecked()
                                || !toggleButtonParentPartner.isChecked()) {
                            String finalText = temp.replace(allStaff, CFT);
                            textPreviewIntroduction.setText(finalText);
                        }
                    }
//
                }
            }
        });
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Add Person");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (items[which].equals("caregiver")) {
                            final EditText taskEditText = new EditText(getActivity());
                            taskEditText.setSingleLine();
                            taskEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_WORDS);
                            taskEditText.setInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
                            final AlertDialog alertDialogdialog = new AlertDialog.Builder(getActivity())
                                    .setTitle("What is the name of the caregiver?")
                                    .setView(taskEditText)
                                    .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(final DialogInterface dialog, int which) {
                                            final String task = String.valueOf(taskEditText.getText());
                                            if (number == 0) {
                                                buttonText1 = "caregiver (" + task + ")";
                                                buttonAddPerson.setVisibility(View.VISIBLE);
                                                buttonAddPerson.setText("caregiver (" + task + ")");
                                                buttonAddPerson.setTextOff("caregiver (" + task + ")");
                                                buttonAddPerson.setTextOn("caregiver (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn1", buttonText1).commit();

                                            } else if (number == 1) {
                                                buttonText2 = "caregiver (" + task + ")";
                                                toggleButton12.setVisibility(View.VISIBLE);
                                                toggleButton12.setText("caregiver (" + task + ")");
                                                toggleButton12.setTextOff("caregiver (" + task + ")");
                                                toggleButton12.setTextOn("caregiver (" + task + ")");
                                                editor.putString(clientId + " btn2", buttonText2).commit();
                                                number++;
                                            } else if (number == 2) {
                                                buttonText3 = "caregiver (" + task + ")";
                                                toggleButton1122.setVisibility(View.VISIBLE);
                                                toggleButton1122.setText("caregiver (" + task + ")");
                                                toggleButton1122.setTextOff("caregiver (" + task + ")");
                                                toggleButton1122.setTextOn("caregiver (" + task + ")");
                                                editor.putString(clientId + " btn3", buttonText3).commit();
                                                number++;
                                            } else if (number == 3) {
                                                buttonText4 = "caregiver (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                toggleButton.setVisibility(View.VISIBLE);
                                                toggleButton.setText("caregiver (" + task + ")");
                                                toggleButton.setTextOff("caregiver (" + task + ")");
                                                toggleButton.setTextOn("caregiver (" + task + ")");
                                                editor.putString(clientId + " btn4", buttonText4).commit();
                                                number++;
                                            } else if (number == 4) {
                                                buttonText5 = "caregiver (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                toggleButton2.setVisibility(View.VISIBLE);
                                                toggleButton2.setText("caregiver (" + task + ")");
                                                toggleButton2.setTextOff("caregiver (" + task + ")");
                                                toggleButton2.setTextOn("caregiver (" + task + ")");
                                                editor.putString(clientId + " btn5", buttonText5).commit();
                                                number++;
                                            } else if (number == 5) {
                                                buttonText6 = "caregiver (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                button4.setVisibility(View.VISIBLE);
                                                button4.setText("caregiver (" + task + ")");
                                                button4.setTextOff("caregiver (" + task + ")");
                                                button4.setTextOn("caregiver (" + task + ")");
                                                editor.putString(clientId + " btn6", buttonText6).commit();
                                                number++;
                                            } else if (number == 6) {
                                                buttonText7 = "caregiver (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                button3.setVisibility(View.VISIBLE);
                                                button3.setText("caregiver (" + task + ")");
                                                button3.setTextOff("caregiver (" + task + ")");
                                                button3.setTextOn("caregiver (" + task + ")");
                                                editor.putString(clientId + " btn7", buttonText7).commit();
                                            }
                                            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                                            inputMethodManager.hideSoftInputFromWindow(taskEditText.getWindowToken(), 0);
                                        }

                                    })
                                    .setNegativeButton("Cancel", null)
                                    .create();
                            alertDialogdialog.show();
                        } else if (items[which].equals("social worker")) {

                            final EditText taskEditText = new EditText(getActivity());
                            taskEditText.setSingleLine();
                            taskEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_WORDS);
                            taskEditText.setInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
                            AlertDialog alertDialogdialog = new AlertDialog.Builder(getActivity())
                                    .setTitle("What is the name of the social worker?")
                                    .setView(taskEditText)
                                    .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            String task = String.valueOf(taskEditText.getText());
                                            if (number == 0) {
                                                buttonText1 = "social worker (" + task + ")";
                                                buttonAddPerson.setVisibility(View.VISIBLE);
                                                buttonAddPerson.setText("social worker (" + task + ")");
                                                buttonAddPerson.setTextOff("social worker (" + task + ")");
                                                buttonAddPerson.setTextOn("social worker (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn1", buttonText1).commit();
                                            } else if (number == 1) {
                                                buttonText2 = "social worker (" + task + ")";
                                                toggleButton12.setVisibility(View.VISIBLE);
                                                toggleButton12.setText("social worker (" + task + ")");
                                                toggleButton12.setTextOff("social worker (" + task + ")");
                                                toggleButton12.setTextOn("social worker (" + task + ")");
                                                editor.putString(clientId + " btn2", buttonText2).commit();
                                                number++;
                                            } else if (number == 2) {
                                                buttonText3 = "social worker (" + task + ")";
                                                toggleButton1122.setVisibility(View.VISIBLE);
                                                toggleButton1122.setText("social worker (" + task + ")");
                                                toggleButton1122.setTextOff("social worker (" + task + ")");
                                                toggleButton1122.setTextOn("social worker (" + task + ")");
                                                editor.putString(clientId + " btn3", buttonText3).commit();
                                                number++;
                                            } else if (number == 3) {
                                                buttonText4 = "social worker (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                toggleButton.setVisibility(View.VISIBLE);
                                                toggleButton.setText("social worker (" + task + ")");
                                                toggleButton.setTextOff("social worker (" + task + ")");
                                                toggleButton.setTextOn("social worker (" + task + ")");
                                                editor.putString(clientId + " btn4", buttonText4).commit();
                                                number++;
                                            } else if (number == 4) {
                                                buttonText5 = "social worker (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                toggleButton2.setVisibility(View.VISIBLE);
                                                toggleButton2.setText("social worker (" + task + ")");
                                                toggleButton2.setTextOff("social worker (" + task + ")");
                                                toggleButton2.setTextOn("social worker (" + task + ")");
                                                editor.putString(clientId + " btn5", buttonText5).commit();
                                                number++;
                                            } else if (number == 5) {
                                                buttonText6 = "social worker (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                button4.setVisibility(View.VISIBLE);
                                                button4.setText("social worker (" + task + ")");
                                                button4.setTextOff("social worker (" + task + ")");
                                                button4.setTextOn("social worker (" + task + ")");
                                                editor.putString(clientId + " btn6", buttonText6).commit();
                                                number++;
                                            } else if (number == 6) {
                                                buttonText7 = "social worker (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                button3.setVisibility(View.VISIBLE);
                                                button3.setText("social worker (" + task + ")");
                                                button3.setTextOff("social worker (" + task + ")");
                                                button3.setTextOn("social worker (" + task + ")");
                                                editor.putString(clientId + " btn7", buttonText7).commit();
                                            }

                                            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                                            inputMethodManager.hideSoftInputFromWindow(taskEditText.getWindowToken(), 0);
                                        }
                                    })
                                    .setNegativeButton("Cancel", null)
                                    .create();
                            alertDialogdialog.show();

                        } else if (items[which].equals("teacher")) {
                            final EditText taskEditText = new EditText(getActivity());
                            taskEditText.setSingleLine();
                            taskEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_WORDS);
                            taskEditText.setInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
                            AlertDialog alertDialogdialog = new AlertDialog.Builder(getActivity())
                                    .setTitle("What is the name of the teacher?")
                                    .setView(taskEditText)
                                    .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            String task = String.valueOf(taskEditText.getText());
                                            if (number == 0) {
                                                buttonText1 = "teacher (" + task + ")";
                                                buttonAddPerson.setVisibility(View.VISIBLE);
                                                buttonAddPerson.setText("teacher (" + task + ")");
                                                buttonAddPerson.setTextOff("teacher (" + task + ")");
                                                buttonAddPerson.setTextOn("teacher (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn1", buttonText1).commit();
                                            } else if (number == 1) {
                                                buttonText2 = "teacher (" + task + ")";
                                                toggleButton12.setVisibility(View.VISIBLE);
                                                toggleButton12.setText("teacher (" + task + ")");
                                                toggleButton12.setTextOff("teacher (" + task + ")");
                                                toggleButton12.setTextOn("teacher (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn2", buttonText2).commit();
                                            } else if (number == 2) {
                                                buttonText3 = "teacher (" + task + ")";
                                                toggleButton1122.setVisibility(View.VISIBLE);
                                                toggleButton1122.setText("teacher (" + task + ")");
                                                toggleButton1122.setTextOff("teacher (" + task + ")");
                                                toggleButton1122.setTextOn("teacher (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn3", buttonText3).commit();
                                            } else if (number == 3) {
                                                buttonText4 = "teacher (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                toggleButton.setVisibility(View.VISIBLE);
                                                toggleButton.setText("teacher (" + task + ")");
                                                toggleButton.setTextOff("teacher (" + task + ")");
                                                toggleButton.setTextOn("teacher (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn4", buttonText4).commit();
                                            } else if (number == 4) {
                                                buttonText5 = "teacher (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                toggleButton2.setVisibility(View.VISIBLE);
                                                toggleButton2.setText("teacher (" + task + ")");
                                                toggleButton2.setTextOff("teacher (" + task + ")");
                                                toggleButton2.setTextOn("teacher (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn5", buttonText5).commit();
                                            } else if (number == 5) {
                                                buttonText6 = "teacher (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                button4.setVisibility(View.VISIBLE);
                                                button4.setText("teacher (" + task + ")");
                                                button4.setTextOff("teacher (" + task + ")");
                                                button4.setTextOn("teacher (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn6", buttonText6).commit();
                                            } else if (number == 6) {
                                                buttonText7 = "teacher (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                button3.setVisibility(View.VISIBLE);
                                                button3.setText("teacher (" + task + ")");
                                                button3.setTextOff("teacher (" + task + ")");
                                                button3.setTextOn("teacher (" + task + ")");
                                                editor.putString(clientId + " btn7", buttonText7).commit();
                                            }
                                            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                                            inputMethodManager.hideSoftInputFromWindow(taskEditText.getWindowToken(), 0);
                                        }
                                    })
                                    .setNegativeButton("Cancel", null)
                                    .create();
                            alertDialogdialog.show();
                        } else if (items[which].equals("father")) {
                            final EditText taskEditText = new EditText(getActivity());
                            taskEditText.setSingleLine();
                            taskEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_WORDS);
                            taskEditText.setInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
                            AlertDialog alertDialogdialog = new AlertDialog.Builder(getActivity())
                                    .setTitle("What is the name of the father?")
                                    .setView(taskEditText)
                                    .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            String task = String.valueOf(taskEditText.getText());
                                            if (number == 0) {
                                                buttonText1 = "father (" + task + ")";
                                                buttonAddPerson.setVisibility(View.VISIBLE);
                                                buttonAddPerson.setText("father (" + task + ")");
                                                buttonAddPerson.setTextOff("father (" + task + ")");
                                                buttonAddPerson.setTextOn("father (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn1", buttonText1).commit();
                                            } else if (number == 1) {
                                                buttonText2 = "father (" + task + ")";
                                                toggleButton12.setVisibility(View.VISIBLE);
                                                toggleButton12.setText("father (" + task + ")");
                                                toggleButton12.setTextOff("father (" + task + ")");
                                                toggleButton12.setTextOn("father (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn2", buttonText2).commit();
                                            } else if (number == 2) {
                                                buttonText3 = "father (" + task + ")";
                                                toggleButton1122.setVisibility(View.VISIBLE);
                                                toggleButton1122.setText("father (" + task + ")");
                                                toggleButton1122.setTextOff("father (" + task + ")");
                                                toggleButton1122.setTextOn("father (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn3", buttonText3).commit();
                                            } else if (number == 3) {
                                                buttonText4 = "father (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                toggleButton.setVisibility(View.VISIBLE);
                                                toggleButton.setText("father (" + task + ")");
                                                toggleButton.setTextOff("father (" + task + ")");
                                                toggleButton.setTextOn("father (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn4", buttonText4).commit();
                                            } else if (number == 4) {
                                                buttonText5 = "father (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                toggleButton2.setVisibility(View.VISIBLE);
                                                toggleButton2.setText("father (" + task + ")");
                                                toggleButton2.setTextOff("father (" + task + ")");
                                                toggleButton2.setTextOn("father (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn5", buttonText5).commit();
                                            } else if (number == 5) {
                                                buttonText6 = "father (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                button4.setVisibility(View.VISIBLE);
                                                button4.setText("father (" + task + ")");
                                                button4.setTextOff("father (" + task + ")");
                                                button4.setTextOn("father (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn6", buttonText6).commit();
                                            } else if (number == 6) {
                                                buttonText7 = "father (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                button3.setVisibility(View.VISIBLE);
                                                button3.setText("father (" + task + ")");
                                                button3.setTextOff("father (" + task + ")");
                                                button3.setTextOn("father (" + task + ")");
                                                editor.putString(clientId + " btn7", buttonText7).commit();
                                            }
                                            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                                            inputMethodManager.hideSoftInputFromWindow(taskEditText.getWindowToken(), 0);
                                        }
                                    })
                                    .setNegativeButton("Cancel", null)
                                    .create();
                            alertDialogdialog.show();
                        } else if (items[which].equals("mother")) {
                            final EditText taskEditText = new EditText(getActivity());
                            taskEditText.setSingleLine();
                            taskEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_WORDS);
                            taskEditText.setInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
                            AlertDialog alertDialogdialog = new AlertDialog.Builder(getActivity())
                                    .setTitle("What is the name of the mother?")
                                    .setView(taskEditText)
                                    .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            String task = String.valueOf(taskEditText.getText());
                                            if (number == 0) {
                                                buttonText1 = "mother (" + task + ")";
                                                buttonAddPerson.setVisibility(View.VISIBLE);
                                                buttonAddPerson.setText("mother (" + task + ")");
                                                buttonAddPerson.setTextOff("mother (" + task + ")");
                                                buttonAddPerson.setTextOn("mother (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn1", buttonText1).commit();
                                            } else if (number == 1) {
                                                buttonText2 = "mother (" + task + ")";
                                                toggleButton12.setVisibility(View.VISIBLE);
                                                toggleButton12.setText("mother (" + task + ")");
                                                toggleButton12.setTextOff("mother (" + task + ")");
                                                toggleButton12.setTextOn("mother (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn2", buttonText2).commit();
                                            } else if (number == 2) {
                                                buttonText3 = "mother (" + task + ")";
                                                toggleButton1122.setVisibility(View.VISIBLE);
                                                toggleButton1122.setText("mother (" + task + ")");
                                                toggleButton1122.setTextOff("mother (" + task + ")");
                                                toggleButton1122.setTextOn("mother (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn3", buttonText3).commit();
                                            } else if (number == 3) {
                                                buttonText4 = "mother (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                toggleButton.setVisibility(View.VISIBLE);
                                                toggleButton.setText("mother (" + task + ")");
                                                toggleButton.setTextOff("mother (" + task + ")");
                                                toggleButton.setTextOn("mother (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn4", buttonText4).commit();
                                            } else if (number == 4) {
                                                buttonText5 = "mother (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                toggleButton2.setVisibility(View.VISIBLE);
                                                toggleButton2.setText("mother (" + task + ")");
                                                toggleButton2.setTextOff("mother (" + task + ")");
                                                toggleButton2.setTextOn("mother (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn5", buttonText5).commit();
                                            } else if (number == 5) {
                                                buttonText6 = "mother (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                button4.setVisibility(View.VISIBLE);
                                                button4.setText("mother (" + task + ")");
                                                button4.setTextOff("mother (" + task + ")");
                                                button4.setTextOn("mother (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn6", buttonText6).commit();
                                            } else if (number == 6) {
                                                buttonText7 = "mother (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                button3.setVisibility(View.VISIBLE);
                                                button3.setText("mother (" + task + ")");
                                                button3.setTextOff("mother (" + task + ")");
                                                button3.setTextOn("mother (" + task + ")");
                                                editor.putString(clientId + " btn7", buttonText7).commit();
                                            }
                                            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                                            inputMethodManager.hideSoftInputFromWindow(taskEditText.getWindowToken(), 0);
                                        }
                                    })
                                    .setNegativeButton("Cancel", null)
                                    .create();
                            alertDialogdialog.show();
                        } else if (items[which].equals("brother")) {
                            final EditText taskEditText = new EditText(getActivity());
                            taskEditText.setSingleLine();
                            taskEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_WORDS);
                            taskEditText.setInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
                            AlertDialog alertDialogdialog = new AlertDialog.Builder(getActivity())
                                    .setTitle("What is the name of the brother?")
                                    .setView(taskEditText)
                                    .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            String task = String.valueOf(taskEditText.getText());
                                            if (number == 0) {
                                                buttonText1 = "brother (" + task + ")";
                                                buttonAddPerson.setVisibility(View.VISIBLE);
                                                buttonAddPerson.setText("brother (" + task + ")");
                                                buttonAddPerson.setTextOff("brother (" + task + ")");
                                                buttonAddPerson.setTextOn("brother (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn1", buttonText1).commit();
                                            } else if (number == 1) {
                                                buttonText2 = "brother (" + task + ")";
                                                toggleButton12.setVisibility(View.VISIBLE);
                                                toggleButton12.setText("brother (" + task + ")");
                                                toggleButton12.setTextOff("brother (" + task + ")");
                                                toggleButton12.setTextOn("brother (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn2", buttonText2).commit();
                                            } else if (number == 2) {
                                                buttonText3 = "brother (" + task + ")";
                                                toggleButton1122.setVisibility(View.VISIBLE);
                                                toggleButton1122.setText("brother (" + task + ")");
                                                toggleButton1122.setTextOff("brother (" + task + ")");
                                                toggleButton1122.setTextOn("brother (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn3", buttonText3).commit();
                                            } else if (number == 3) {
                                                buttonText4 = "brother (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                toggleButton.setVisibility(View.VISIBLE);
                                                toggleButton.setText("brother (" + task + ")");
                                                toggleButton.setTextOff("brother (" + task + ")");
                                                toggleButton.setTextOn("brother (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn4", buttonText4).commit();
                                            } else if (number == 4) {
                                                buttonText5 = "brother (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                toggleButton2.setVisibility(View.VISIBLE);
                                                toggleButton2.setText("brother (" + task + ")");
                                                toggleButton2.setTextOff("brother (" + task + ")");
                                                toggleButton2.setTextOn("brother (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn5", buttonText5).commit();
                                            } else if (number == 5) {
                                                buttonText6 = "brother (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                button4.setVisibility(View.VISIBLE);
                                                button4.setText("brother (" + task + ")");
                                                button4.setTextOff("brother (" + task + ")");
                                                button4.setTextOn("brother (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn6", buttonText6).commit();
                                            } else if (number == 6) {
                                                buttonText7 = "brother (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                button3.setVisibility(View.VISIBLE);
                                                button3.setText("brother (" + task + ")");
                                                button3.setTextOff("brother (" + task + ")");
                                                button3.setTextOn("brother (" + task + ")");
                                                editor.putString(clientId + " btn7", buttonText7).commit();
                                            }
                                            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                                            inputMethodManager.hideSoftInputFromWindow(taskEditText.getWindowToken(), 0);
                                        }
                                    })
                                    .setNegativeButton("Cancel", null)
                                    .create();
                            alertDialogdialog.show();
                        } else if (items[which].equals("sister")) {
                            final EditText taskEditText = new EditText(getActivity());
                            taskEditText.setSingleLine();
                            taskEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_WORDS);
                            taskEditText.setInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
                            AlertDialog alertDialogdialog = new AlertDialog.Builder(getActivity())
                                    .setTitle("What is the name of the sister?")
                                    .setView(taskEditText)
                                    .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            String task = String.valueOf(taskEditText.getText());
                                            if (number == 0) {
                                                buttonText1 = "sister (" + task + ")";
                                                buttonAddPerson.setVisibility(View.VISIBLE);
                                                buttonAddPerson.setText("sister (" + task + ")");
                                                buttonAddPerson.setTextOff("sister (" + task + ")");
                                                buttonAddPerson.setTextOn("sister (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn1", buttonText1).commit();
                                            } else if (number == 1) {
                                                buttonText2 = "sister (" + task + ")";
                                                toggleButton12.setVisibility(View.VISIBLE);
                                                toggleButton12.setText("sister (" + task + ")");
                                                toggleButton12.setTextOff("sister (" + task + ")");
                                                toggleButton12.setTextOn("sister (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn2", buttonText2).commit();
                                            } else if (number == 2) {
                                                buttonText3 = "sister (" + task + ")";
                                                toggleButton1122.setVisibility(View.VISIBLE);
                                                toggleButton1122.setText("sister (" + task + ")");
                                                toggleButton1122.setTextOff("sister (" + task + ")");
                                                toggleButton1122.setTextOn("sister (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn3", buttonText3).commit();
                                            } else if (number == 3) {
                                                buttonText4 = "sister (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                toggleButton.setVisibility(View.VISIBLE);
                                                toggleButton.setText("sister (" + task + ")");
                                                toggleButton.setTextOff("sister (" + task + ")");
                                                toggleButton.setTextOn("sister (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn4", buttonText4).commit();
                                            } else if (number == 4) {
                                                buttonText5 = "sister (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                toggleButton2.setVisibility(View.VISIBLE);
                                                toggleButton2.setText("sister (" + task + ")");
                                                toggleButton2.setTextOff("sister (" + task + ")");
                                                toggleButton2.setTextOn("sister (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn5", buttonText5).commit();
                                            } else if (number == 5) {
                                                buttonText6 = "sister (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                button4.setVisibility(View.VISIBLE);
                                                button4.setText("sister (" + task + ")");
                                                button4.setTextOff("sister (" + task + ")");
                                                button4.setTextOn("sister (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn6", buttonText6).commit();
                                            } else if (number == 6) {
                                                buttonText7 = "sister (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                button3.setVisibility(View.VISIBLE);
                                                button3.setText("sister (" + task + ")");
                                                button3.setTextOff("sister (" + task + ")");
                                                button3.setTextOn("sister (" + task + ")");
                                                editor.putString(clientId + " btn7", buttonText7).commit();
                                            }
                                            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                                            inputMethodManager.hideSoftInputFromWindow(taskEditText.getWindowToken(), 0);
                                        }
                                    })
                                    .setNegativeButton("Cancel", null)
                                    .create();
                            alertDialogdialog.show();
                        } else if (items[which].equals("grandfather")) {
                            final EditText taskEditText = new EditText(getActivity());
                            taskEditText.setSingleLine();
                            taskEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_WORDS);
                            taskEditText.setInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
                            AlertDialog alertDialogdialog = new AlertDialog.Builder(getActivity())
                                    .setTitle("What is the name of the grandfather?")
                                    .setView(taskEditText)
                                    .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            String task = String.valueOf(taskEditText.getText());
                                            if (number == 0) {
                                                buttonText1 = "grandfather (" + task + ")";
                                                buttonAddPerson.setVisibility(View.VISIBLE);
                                                buttonAddPerson.setText("grandfather (" + task + ")");
                                                buttonAddPerson.setTextOff("grandfather (" + task + ")");
                                                buttonAddPerson.setTextOn("grandfather (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn1", buttonText1).commit();
                                            } else if (number == 1) {
                                                buttonText2 = "grandfather (" + task + ")";
                                                toggleButton12.setVisibility(View.VISIBLE);
                                                toggleButton12.setText("grandfather (" + task + ")");
                                                toggleButton12.setTextOff("grandfather (" + task + ")");
                                                toggleButton12.setTextOn("grandfather (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn2", buttonText2).commit();
                                            } else if (number == 2) {
                                                buttonText3 = "grandfather (" + task + ")";
                                                toggleButton1122.setVisibility(View.VISIBLE);
                                                toggleButton1122.setText("grandfather (" + task + ")");
                                                toggleButton1122.setTextOff("grandfather (" + task + ")");
                                                toggleButton1122.setTextOn("grandfather (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn3", buttonText3).commit();
                                            } else if (number == 3) {
                                                buttonText4 = "grandfather (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                toggleButton.setVisibility(View.VISIBLE);
                                                toggleButton.setText("grandfather (" + task + ")");
                                                toggleButton.setTextOff("grandfather (" + task + ")");
                                                toggleButton.setTextOn("grandfather (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn4", buttonText4).commit();
                                            } else if (number == 4) {
                                                buttonText5 = "grandfather (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                toggleButton2.setVisibility(View.VISIBLE);
                                                toggleButton2.setText("grandfather (" + task + ")");
                                                toggleButton2.setTextOff("grandfather (" + task + ")");
                                                toggleButton2.setTextOn("grandfather (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn5", buttonText5).commit();
                                            } else if (number == 5) {
                                                buttonText6 = "grandfather (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                button4.setVisibility(View.VISIBLE);
                                                button4.setText("grandfather (" + task + ")");
                                                button4.setTextOff("grandfather (" + task + ")");
                                                button4.setTextOn("grandfather (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn6", buttonText6).commit();
                                            } else if (number == 6) {
                                                buttonText7 = "grandfather (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                button3.setVisibility(View.VISIBLE);
                                                button3.setText("grandfather (" + task + ")");
                                                button3.setTextOff("grandfather (" + task + ")");
                                                button3.setTextOn("grandfather (" + task + ")");
                                                editor.putString(clientId + " btn7", buttonText7).commit();
                                            }
                                            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                                            inputMethodManager.hideSoftInputFromWindow(taskEditText.getWindowToken(), 0);
                                        }
                                    })
                                    .setNegativeButton("Cancel", null)
                                    .create();
                            alertDialogdialog.show();
                        } else if (items[which].equals("grandmother")) {
                            final EditText taskEditText = new EditText(getActivity());
                            taskEditText.setSingleLine();
                            taskEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_WORDS);
                            taskEditText.setInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
                            AlertDialog alertDialogdialog = new AlertDialog.Builder(getActivity())
                                    .setTitle("What is the name of the grandmother?")
                                    .setView(taskEditText)
                                    .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            String task = String.valueOf(taskEditText.getText());
                                            if (number == 0) {
                                                buttonText1 = "grandmother (" + task + ")";
                                                buttonAddPerson.setVisibility(View.VISIBLE);
                                                buttonAddPerson.setText("grandmother (" + task + ")");
                                                buttonAddPerson.setTextOff("grandmother (" + task + ")");
                                                buttonAddPerson.setTextOn("grandmother (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn1", buttonText1).commit();
                                            } else if (number == 1) {
                                                buttonText2 = "grandmother (" + task + ")";
                                                toggleButton12.setVisibility(View.VISIBLE);
                                                toggleButton12.setText("grandmother (" + task + ")");
                                                toggleButton12.setTextOff("grandmother (" + task + ")");
                                                toggleButton12.setTextOn("grandmother (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn2", buttonText2).commit();
                                            } else if (number == 2) {
                                                buttonText3 = "grandmother (" + task + ")";
                                                toggleButton1122.setVisibility(View.VISIBLE);
                                                toggleButton1122.setText("grandmother (" + task + ")");
                                                toggleButton1122.setTextOff("grandmother (" + task + ")");
                                                toggleButton1122.setTextOn("grandmother (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn3", buttonText3).commit();
                                            } else if (number == 3) {
                                                buttonText4 = "grandmother (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                toggleButton.setVisibility(View.VISIBLE);
                                                toggleButton.setText("grandmother (" + task + ")");
                                                toggleButton.setTextOff("grandmother (" + task + ")");
                                                toggleButton.setTextOn("grandmother (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn4", buttonText4).commit();
                                            } else if (number == 4) {
                                                buttonText5 = "grandmother (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                toggleButton2.setVisibility(View.VISIBLE);
                                                toggleButton2.setText("grandmother (" + task + ")");
                                                toggleButton2.setTextOff("grandmother (" + task + ")");
                                                toggleButton2.setTextOn("grandmother (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn5", buttonText5).commit();
                                            } else if (number == 5) {
                                                buttonText6 = "grandmother (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                button4.setVisibility(View.VISIBLE);
                                                button4.setText("grandmother (" + task + ")");
                                                button4.setTextOff("grandmother (" + task + ")");
                                                button4.setTextOn("grandmother (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn6", buttonText6).commit();
                                            } else if (number == 6) {
                                                buttonText7 = "grandmother (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                button3.setVisibility(View.VISIBLE);
                                                button3.setText("grandmother (" + task + ")");
                                                button3.setTextOff("grandmother (" + task + ")");
                                                button3.setTextOn("grandmother (" + task + ")");
                                                editor.putString(clientId + " btn7", buttonText7).commit();
                                            }
                                            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                                            inputMethodManager.hideSoftInputFromWindow(taskEditText.getWindowToken(), 0);
                                        }
                                    })
                                    .setNegativeButton("Cancel", null)
                                    .create();
                            alertDialogdialog.show();
                        } else if (items[which].equals("neighbor")) {
                            final EditText taskEditText = new EditText(getActivity());
                            taskEditText.setSingleLine();
                            taskEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_WORDS);
                            taskEditText.setInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
                            AlertDialog alertDialogdialog = new AlertDialog.Builder(getActivity())
                                    .setTitle("What is the name of the neighbor?")
                                    .setView(taskEditText)
                                    .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            String task = String.valueOf(taskEditText.getText());
                                            if (number == 0) {
                                                buttonText1 = "neighbor (" + task + ")";
                                                buttonAddPerson.setVisibility(View.VISIBLE);
                                                buttonAddPerson.setText("neighbor (" + task + ")");
                                                buttonAddPerson.setTextOff("neighbor (" + task + ")");
                                                buttonAddPerson.setTextOn("neighbor (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn1", buttonText1).commit();
                                            } else if (number == 1) {
                                                buttonText2 = "neighbor (" + task + ")";
                                                toggleButton12.setVisibility(View.VISIBLE);
                                                toggleButton12.setText("neighbor (" + task + ")");
                                                toggleButton12.setTextOff("neighbor (" + task + ")");
                                                toggleButton12.setTextOn("neighbor (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn2", buttonText2).commit();
                                            } else if (number == 2) {
                                                buttonText3 = "neighbor (" + task + ")";
                                                toggleButton1122.setVisibility(View.VISIBLE);
                                                toggleButton1122.setText("neighbor (" + task + ")");
                                                toggleButton1122.setTextOff("neighbor (" + task + ")");
                                                toggleButton1122.setTextOn("neighbor (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn3", buttonText3).commit();
                                            } else if (number == 3) {
                                                buttonText4 = "neighbor (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                toggleButton.setVisibility(View.VISIBLE);
                                                toggleButton.setText("neighbor (" + task + ")");
                                                toggleButton.setTextOff("neighbor (" + task + ")");
                                                toggleButton.setTextOn("neighbor (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn4", buttonText4).commit();
                                            } else if (number == 4) {
                                                buttonText5 = "neighbor (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                toggleButton2.setVisibility(View.VISIBLE);
                                                toggleButton2.setText("neighbor (" + task + ")");
                                                toggleButton2.setTextOff("neighbor (" + task + ")");
                                                toggleButton2.setTextOn("neighbor (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn5", buttonText5).commit();
                                            } else if (number == 5) {
                                                buttonText6 = "neighbor (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                button4.setVisibility(View.VISIBLE);
                                                button4.setText("neighbor (" + task + ")");
                                                button4.setTextOff("neighbor (" + task + ")");
                                                button4.setTextOn("neighbor (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn6", buttonText6).commit();
                                            } else if (number == 6) {
                                                buttonText7 = "neighbor (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                button3.setVisibility(View.VISIBLE);
                                                button3.setText("neighbor (" + task + ")");
                                                button3.setTextOff("neighbor (" + task + ")");
                                                button3.setTextOn("neighbor (" + task + ")");
                                                editor.putString(clientId + " btn7", buttonText7).commit();
                                            }
                                            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                                            inputMethodManager.hideSoftInputFromWindow(taskEditText.getWindowToken(), 0);
                                        }
                                    })
                                    .setNegativeButton("Cancel", null)
                                    .create();
                            alertDialogdialog.show();
                        } else if (items[which].equals("friend")) {
                            final EditText taskEditText = new EditText(getActivity());
                            taskEditText.setSingleLine();
                            taskEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_WORDS);
                            taskEditText.setInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
                            AlertDialog alertDialogdialog = new AlertDialog.Builder(getActivity())
                                    .setTitle("What is the name of the friend?")
                                    .setView(taskEditText)
                                    .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            String task = String.valueOf(taskEditText.getText());
                                            if (number == 0) {
                                                buttonText1 = "friend (" + task + ")";
                                                buttonAddPerson.setVisibility(View.VISIBLE);
                                                buttonAddPerson.setText("friend (" + task + ")");
                                                buttonAddPerson.setTextOff("friend (" + task + ")");
                                                buttonAddPerson.setTextOn("friend (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn1", buttonText1).commit();
                                            } else if (number == 1) {
                                                buttonText2 = "friend (" + task + ")";
                                                toggleButton12.setVisibility(View.VISIBLE);
                                                toggleButton12.setText("friend (" + task + ")");
                                                toggleButton12.setTextOff("friend (" + task + ")");
                                                toggleButton12.setTextOn("friend (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn2", buttonText2).commit();
                                            } else if (number == 2) {
                                                buttonText3 = "friend (" + task + ")";
                                                toggleButton1122.setVisibility(View.VISIBLE);
                                                toggleButton1122.setText("friend (" + task + ")");
                                                toggleButton1122.setTextOff("friend (" + task + ")");
                                                toggleButton1122.setTextOn("friend (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn3", buttonText3).commit();
                                            } else if (number == 3) {
                                                buttonText4 = "friend (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                toggleButton.setVisibility(View.VISIBLE);
                                                toggleButton.setText("friend (" + task + ")");
                                                toggleButton.setTextOff("friend (" + task + ")");
                                                toggleButton.setTextOn("friend (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn4", buttonText4).commit();
                                            } else if (number == 4) {
                                                buttonText5 = "friend (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                toggleButton2.setVisibility(View.VISIBLE);
                                                toggleButton2.setText("friend (" + task + ")");
                                                toggleButton2.setTextOff("friend (" + task + ")");
                                                toggleButton2.setTextOn("friend (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn5", buttonText5).commit();
                                            } else if (number == 5) {
                                                buttonText6 = "friend (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                button4.setVisibility(View.VISIBLE);
                                                button4.setText("friend (" + task + ")");
                                                button4.setTextOff("friend (" + task + ")");
                                                button4.setTextOn("friend (" + task + ")");
                                                number++;
                                                editor.putString(clientId + " btn6", buttonText6).commit();
                                            } else if (number == 6) {
                                                buttonText7 = "friend (" + task + ")";
                                                linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                                                button3.setVisibility(View.VISIBLE);
                                                button3.setText("friend (" + task + ")");
                                                button3.setTextOff("friend (" + task + ")");
                                                button3.setTextOn("friend (" + task + ")");
                                                editor.putString(clientId + " btn7", buttonText7).commit();
                                            }
                                            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                                            inputMethodManager.hideSoftInputFromWindow(taskEditText.getWindowToken(), 0);
                                        }
                                    })
                                    .setNegativeButton("Cancel", null)
                                    .create();
                            alertDialogdialog.show();
                        } else if (items[which].equals("Cancel")) {
                            dialog.dismiss();
                        }

                    }
                });
                builder.show();
            }
        });

        toggleButton2.setOnClickListener(this);
        toggleButton.setOnClickListener(this);
        toggleButton12.setOnClickListener(this);
        toggleButtonTherapist.setOnClickListener(this);
        toggleButtonParentPartner.setOnClickListener(this);
        toggleButtonFacilitator.setOnClickListener(this);
        toggleButtonCFS.setOnClickListener(this);
        toggleButton1122.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        toggleButtonClient.setOnClickListener(this);
        buttonAddPerson.setOnClickListener(this);


        spinnerAddress1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                if (item.equals("My Home")) {
                    entryAddress1City.setVisibility(View.VISIBLE);
                    entryAddress1State.setVisibility(View.VISIBLE);
                    entryAddress1Street.setVisibility(View.VISIBLE);
                    entryAddress1Zip.setVisibility(View.VISIBLE);

                    entryAddress1Street.setText("11155 183rd St");
                    entryAddress1City.setText("Cerritos");
                    entryAddress1State.setText("CA");
                    entryAddress1Zip.setText("90703");

                    String text = entryAddress2City.getText().toString();
                    //address1 = "11155 183rd St "+"Cerritos "+"CA "+"90703";
//                    editor.putString("address1",address1).commit();

                    if (text.isEmpty()) {
                        textPreviewIntroduction.setText("The CFS traveled from Cerritos to ");
                    } else {
                        textPreviewIntroduction.setText("The CFS traveled from Cerritos to " + spinnerAddress2.getSelectedItem() + " in " + entryAddress2City.getText() + " for ");

                    }


                    linearLayoutAddress2.setVisibility(View.VISIBLE);
                    spinnerAddress2.setVisibility(View.VISIBLE);
                } else if (item.equals("SPA 2: Reseda")) {
                    entryAddress1City.setVisibility(View.VISIBLE);
                    entryAddress1State.setVisibility(View.VISIBLE);
                    entryAddress1Street.setVisibility(View.VISIBLE);
                    entryAddress1Zip.setVisibility(View.VISIBLE);

                    entryAddress1Street.setText("7601 Canby Ave, Suite 3");
                    entryAddress1City.setText("Reseda");
                    entryAddress1State.setText("CA");
                    entryAddress1Zip.setText("91335");

//                    address1 = "7601 Canby Ave, Suite 3 "+"Reseda "+"CA "+"91335 ";
//                    editor.putString("address1",address1).commit();


                    String text = entryAddress2City.getText().toString();
                    if (text.isEmpty()) {
                        textPreviewIntroduction.setText("The CFS traveled from Reseda to ");
                    } else {
                        textPreviewIntroduction.setText("The CFS traveled from Reseda to " + spinnerAddress2.getSelectedItem() + " in " + entryAddress2City.getText() + " for ");
                    }

                    linearLayoutAddress2.setVisibility(View.VISIBLE);
                    spinnerAddress2.setVisibility(View.VISIBLE);
                } else if (item.equals("SPA 4: LA Metro")) {
                    entryAddress1City.setVisibility(View.VISIBLE);
                    entryAddress1State.setVisibility(View.VISIBLE);
                    entryAddress1Street.setVisibility(View.VISIBLE);
                    entryAddress1Zip.setVisibility(View.VISIBLE);

                    entryAddress1Street.setText("1625 W. Olympic Blvd");
                    entryAddress1City.setText("Los Angeles");
                    entryAddress1State.setText("CA");
                    entryAddress1Zip.setText("90015");

//                    address1 = "1625 W. Olympic Blvd "+"Los Angeles "+"CA "+"90015";
//                    editor.putString("address1",address1).commit();

                    String text = entryAddress2City.getText().toString();
                    if (text.isEmpty()) {
                        textPreviewIntroduction.setText("The CFS traveled from Los Angeles to ");
                    } else {
                        textPreviewIntroduction.setText("The CFS traveled from Los Angeles to " + spinnerAddress2.getSelectedItem() + " in " + entryAddress2City.getText() + " for ");
                    }


                    linearLayoutAddress2.setVisibility(View.VISIBLE);
                    spinnerAddress2.setVisibility(View.VISIBLE);
                } else if (item.equals("SPA 6: Compton")) {
                    entryAddress1City.setVisibility(View.VISIBLE);
                    entryAddress1State.setVisibility(View.VISIBLE);
                    entryAddress1Street.setVisibility(View.VISIBLE);
                    entryAddress1Zip.setVisibility(View.VISIBLE);

                    entryAddress1Street.setText("1303 West Walnut Parkway");
                    entryAddress1City.setText("Compton");
                    entryAddress1State.setText("CA");
                    entryAddress1Zip.setText("90220");

//                    address1 = "1303 West Walnut Parkway "+"Compton "+"CA "+"90220";
//                    editor.putString("address1",address1).commit();

                    String text = entryAddress2City.getText().toString();
                    if (text.isEmpty()) {
                        textPreviewIntroduction.setText("The CFS traveled from Compton to ");
                    } else {
                        textPreviewIntroduction.setText("The CFS traveled from Compton to " + spinnerAddress2.getSelectedItem() + " " + entryAddress2City.getText() + " for ");
                    }


                    linearLayoutAddress2.setVisibility(View.VISIBLE);
                    spinnerAddress2.setVisibility(View.VISIBLE);
                } else if (item.equals("Gutierrez, Joey: Home")) {
                    entryAddress1City.setVisibility(View.VISIBLE);
                    entryAddress1State.setVisibility(View.VISIBLE);
                    entryAddress1Street.setVisibility(View.VISIBLE);
                    entryAddress1Zip.setVisibility(View.VISIBLE);

                    entryAddress1Street.setText("14441 Inglewood Avenue");
                    entryAddress1City.setText("Hawthorne");
                    entryAddress1State.setText("CA");
                    entryAddress1Zip.setText("90250");

//                    address1 = "14441 Inglewood Avenue "+"Hawthorne "+"CA "+"90250";
//                    editor.putString("address1",address1).commit();

                    String text = entryAddress2City.getText().toString();
                    if (text.isEmpty()) {
                        textPreviewIntroduction.setText("The CFS traveled from Hawthorne to ");
                    } else {
                        textPreviewIntroduction.setText("The CFS traveled from Hawthorne to " + spinnerAddress2.getSelectedItem() + " in " + entryAddress2City.getText() + " for ");
                    }


                    linearLayoutAddress2.setVisibility(View.VISIBLE);
                    spinnerAddress2.setVisibility(View.VISIBLE);
                } else if (item.equals("Dakota, Cassie: Home")) {
                    entryAddress1City.setVisibility(View.VISIBLE);
                    entryAddress1State.setVisibility(View.VISIBLE);
                    entryAddress1Street.setVisibility(View.VISIBLE);
                    entryAddress1Zip.setVisibility(View.VISIBLE);

                    entryAddress1Street.setText("3943 Grand Avenue");
                    entryAddress1City.setText("Chino");
                    entryAddress1State.setText("CA");
                    entryAddress1Zip.setText("91710");

//                    address1 = "3943 Grand Avenue "+"Chino "+"CA "+"91710";
//                    editor.putString("address1",address1).commit();

                    String text = entryAddress2City.getText().toString();
                    if (text.isEmpty()) {
                        textPreviewIntroduction.setText("The CFS traveled from Chino to ");

                    } else {
                        textPreviewIntroduction.setText("The CFS traveled from Chino to " + spinnerAddress2.getSelectedItem() + " in " + entryAddress2City.getText() + " for ");

                    }

                    linearLayoutAddress2.setVisibility(View.VISIBLE);
                    spinnerAddress2.setVisibility(View.VISIBLE);
                } else if (item.equals("Burka, Robert: Home")) {
                    entryAddress1City.setVisibility(View.VISIBLE);
                    entryAddress1State.setVisibility(View.VISIBLE);
                    entryAddress1Street.setVisibility(View.VISIBLE);
                    entryAddress1Zip.setVisibility(View.VISIBLE);

                    entryAddress1Street.setText("3705 East South Street");
                    entryAddress1City.setText("Long Beach");
                    entryAddress1State.setText("CA");
                    entryAddress1Zip.setText("90805");

//                    address1 = "3705 East South Street "+"Long Beach "+"CA "+"90805";
//                    editor.putString("address1",address1).commit();

                    String text = entryAddress2City.getText().toString();
                    if (text.isEmpty()) {
                        textPreviewIntroduction.setText("The CFS traveled from Long Beach to ");
                    } else {
                        textPreviewIntroduction.setText("The CFS traveled from Long Beach to " + spinnerAddress2.getSelectedItem() + " in " + entryAddress2City.getText() + " for ");
                    }

                    linearLayoutAddress2.setVisibility(View.VISIBLE);
                    spinnerAddress2.setVisibility(View.VISIBLE);

                } else if (item.equals("Phone")) {
                    entryAddress1City.setVisibility(View.INVISIBLE);
                    entryAddress1State.setVisibility(View.INVISIBLE);
                    entryAddress1Street.setVisibility(View.INVISIBLE);
                    entryAddress1Zip.setVisibility(View.INVISIBLE);

                    textPreviewIntroduction.setText("");
                    linearLayoutAddress2.setVisibility(View.INVISIBLE);
                } else if (item.equals("Custom")) {
                    entryAddress1City.setVisibility(View.VISIBLE);
                    entryAddress1State.setVisibility(View.VISIBLE);
                    entryAddress1Street.setVisibility(View.VISIBLE);
                    entryAddress1Zip.setVisibility(View.VISIBLE);

                    entryAddress1Street.setText("");
                    entryAddress1City.setText("");
                    entryAddress1State.setText("");
                    entryAddress1Zip.setText("");

                    textPreviewIntroduction.setText("");

                    if (!entryAddress1Street.equals("") && !entryAddress1Zip.equals("") && !entryAddress1State.equals("") && !entryAddress1City.equals("")) {

                        textPreviewIntroduction.setText("The CFS traveled from " + entryAddress1City.getText());
                        linearLayoutAddress2.setVisibility(View.VISIBLE);
                        spinnerAddress2.setVisibility(View.VISIBLE);
                    }

                } else if (item.equals("Starting Location")) {
                    entryAddress1City.setVisibility(View.INVISIBLE);
                    entryAddress1State.setVisibility(View.INVISIBLE);
                    entryAddress1Street.setVisibility(View.INVISIBLE);
                    entryAddress1Zip.setVisibility(View.INVISIBLE);

                    textPreviewIntroduction.setText("The CFS traveled from");
                    linearLayoutAddress2.setVisibility(View.INVISIBLE);
                    spinnerAddress2.setVisibility(View.INVISIBLE);
                }

                address1 = entryAddress1Street.getText().toString() + entryAddress1City.getText().toString() + entryAddress1State.getText().toString() + " " + entryAddress1Zip.getText().toString();
                editor.putString("address1", address1).commit();
                editor.putString("street", entryAddress1Street.getText().toString()).commit();
                editor.putString("zip", entryAddress1Zip.getText().toString()).commit();
                Log.d("address", address1);
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerAddress2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                if (item.equals(clientName + ": Home")) {
                    // apicallHomeAddress();
                    editor.putString("add2title", "Home").commit();
                    homeStreet = sharedPreferences.getString("Hstreet", "");
                    homeCity = sharedPreferences.getString("Hcity", "");
                    homeZip = sharedPreferences.getString("Hzip", "");
                    homeState = sharedPreferences.getString("HState", "");

                    entryAddress2Street.setText(homeStreet);
                    entryAddress2City.setText(homeCity);
                    entryAddress2State.setText(homeState);
                    entryAddress2Zip.setText(homeZip);

                    textPreviewIntroduction.setText("The CFS traveled from " + entryAddress1City.getText() + " to client's home" + " in " + entryAddress2City.getText() + " for ");

                    linearLayoutPeoplePresentRow1.setVisibility(View.VISIBLE);
                    linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                    linearLayoutPeoplePresentTeamRow.setVisibility(View.VISIBLE);
                    entryAddress2City.setVisibility(View.VISIBLE);
                    entryAddress2Street.setVisibility(View.VISIBLE);
                    entryAddress2Zip.setVisibility(View.VISIBLE);
                    entryAddress2State.setVisibility(View.VISIBLE);
                    fab.setVisibility(View.VISIBLE);
                } else if (item.equals(clientName + ": School")) {
                    //apiSchoolAddressCall();
                    editor.putString("add2title", "School").commit();
                    schoolStreet = sharedPreferences.getString("Sstreet", "");
                    schoolCity = sharedPreferences.getString("Scity", "");
                    schoolState = sharedPreferences.getString("Sstate", "");
                    schoolZip = sharedPreferences.getString("Szip", "");

                    entryAddress2Street.setText(schoolStreet);
                    entryAddress2City.setText(schoolCity);
                    entryAddress2State.setText(schoolState);
                    entryAddress2Zip.setText(schoolZip);

                    textPreviewIntroduction.setText("The CFS traveled from " + entryAddress1City.getText() + " to Foster Middle School" + " in " + entryAddress2City.getText() + " for ");

                    linearLayoutPeoplePresentRow1.setVisibility(View.VISIBLE);
                    linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                    fab.setVisibility(View.VISIBLE);
                    linearLayoutPeoplePresentTeamRow.setVisibility(View.VISIBLE);
                    entryAddress2City.setVisibility(View.VISIBLE);
                    entryAddress2Street.setVisibility(View.VISIBLE);
                    entryAddress2Zip.setVisibility(View.VISIBLE);
                    entryAddress2State.setVisibility(View.VISIBLE);
                } else if (item.equals("Custom")) {

                    entryAddress2City.setText("");
                    entryAddress2State.setText("");
                    entryAddress2Street.setText("");
                    entryAddress2Zip.setText("");
                    linearLayoutPeoplePresentRow1.setVisibility(View.VISIBLE);
                    linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                    linearLayoutPeoplePresentTeamRow.setVisibility(View.VISIBLE);
                    fab.setVisibility(View.VISIBLE);
                    entryAddress2City.setVisibility(View.VISIBLE);
                    entryAddress2Street.setVisibility(View.VISIBLE);
                    entryAddress2Zip.setVisibility(View.VISIBLE);
                    entryAddress2State.setVisibility(View.VISIBLE);
                    editor.putString("add2title", entryAddress2City.getText().toString()).commit();
                } else if (item.equals("SPA 2: Reseda")) {
                    editor.putString("add2title", "SPA 2: Reseda").commit();
                    entryAddress2Street.setText("7601 Canby Ave, Suite 3");
                    entryAddress2City.setText("Reseda");
                    entryAddress2State.setText("CA");
                    entryAddress2Zip.setText("91335");
                    linearLayoutPeoplePresentRow1.setVisibility(View.VISIBLE);
                    linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                    linearLayoutPeoplePresentTeamRow.setVisibility(View.VISIBLE);
                    fab.setVisibility(View.VISIBLE);
                    entryAddress2City.setVisibility(View.VISIBLE);
                    entryAddress2Street.setVisibility(View.VISIBLE);
                    entryAddress2Zip.setVisibility(View.VISIBLE);
                    entryAddress2State.setVisibility(View.VISIBLE);

//                    address2 = "7601 Canby Ave, Suite 3 "+"Reseda "+"CA "+"91335 ";
//                    editor.putString("address2",address2).commit();

                    textPreviewIntroduction.setText("The CFS traveled from " + entryAddress1City.getText() + " to " + spinnerAddress2.getSelectedItem() + " in " + entryAddress2City.getText() + " for ");
                } else if (item.equals("SPA 4: LA Metro")) {
                    editor.putString("add2title", "SPA 4: LA Metro").commit();
                    entryAddress2Street.setText("1625 W. Olympic Blvd");
                    entryAddress2City.setText("Los Angeles");
                    entryAddress2State.setText("CA");
                    entryAddress2Zip.setText("90015");

                    linearLayoutPeoplePresentRow1.setVisibility(View.VISIBLE);
                    linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                    linearLayoutPeoplePresentTeamRow.setVisibility(View.VISIBLE);
                    fab.setVisibility(View.VISIBLE);
                    entryAddress2City.setVisibility(View.VISIBLE);
                    entryAddress2Street.setVisibility(View.VISIBLE);
                    entryAddress2Zip.setVisibility(View.VISIBLE);
                    entryAddress2State.setVisibility(View.VISIBLE);

//                    address2 = "1625 W. Olympic Blvd "+"Los Angeles "+"CA "+"90015";
//                    editor.putString("address2",address2).commit();

                    textPreviewIntroduction.setText("The CFS traveled from " + entryAddress1City.getText() + " to " + spinnerAddress2.getSelectedItem() + " in " + entryAddress2City.getText() + " for ");
                } else if (item.equals("SPA 6: Compton")) {
                    editor.putString("add2title", "SPA 6: Compton").commit();
                    entryAddress2Street.setText("1303 West Walnut Parkway");
                    entryAddress2City.setText("Compton");
                    entryAddress2State.setText("CA");
                    entryAddress2Zip.setText("90220");

                    linearLayoutPeoplePresentRow1.setVisibility(View.VISIBLE);
                    linearLayoutPeoplePresentRow2.setVisibility(View.VISIBLE);
                    linearLayoutPeoplePresentTeamRow.setVisibility(View.VISIBLE);
                    fab.setVisibility(View.VISIBLE);
                    entryAddress2City.setVisibility(View.VISIBLE);
                    entryAddress2Street.setVisibility(View.VISIBLE);
                    entryAddress2Zip.setVisibility(View.VISIBLE);
                    entryAddress2State.setVisibility(View.VISIBLE);

//                    address2 = "1303 West Walnut Parkway "+"Compton "+"CA "+"90220";
//                    editor.putString("address2",address2).commit();

                    textPreviewIntroduction.setText("The CFS traveled from " + entryAddress1City.getText() + " to " + spinnerAddress2.getSelectedItem() + " in " + entryAddress2City.getText() + " for ");
                }

                address2 = entryAddress2Street.getText().toString() + entryAddress2City.getText().toString() + entryAddress2State.getText().toString() + " " + entryAddress2Zip.getText().toString();
                editor.putString("address2", address2).commit();
                editor.putString("street2", entryAddress2Street.getText().toString()).commit();
                editor.putString("zip2", entryAddress2Zip.getText().toString());


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    public static String getCurrentTimeStamp() {
        try {

            Calendar c = Calendar.getInstance();
            System.out.println("Current time => " + c.getTime());

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            String formattedDate = df.format(c.getTime());

            editor.putString("2k1DateAndTime", formattedDate).commit();

            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm");
            String currentDateTime = dateFormat.format(new Date());
            Log.d("zmaDate", currentDateTime);

            editor.putString("2k1Date", currentDateTime).commit();

            return currentDateTime;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    private void customActionBar() {
        android.support.v7.app.ActionBar mActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        mActionBar.setDisplayHomeAsUpEnabled(true);
        LayoutInflater mInflater = LayoutInflater.from(getActivity());
        View mCustomView = mInflater.inflate(R.layout.custom_actionbar_progressnote, null);
        final TextView textView = (TextView) mCustomView.findViewById(R.id.textView2);
        //final String barTitle=clientName+" - "+"Progress Note";
        final String barTitle = "Progress Note";
        textView.setText(barTitle);


        button = (Button) mCustomView.findViewById(R.id.btnGoal);
        if (test > 0) {
            button.setVisibility(View.VISIBLE);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (teamMember == 4 && otherProfessional + friends + familyMembers > 0) {
                    Code = "ICC PN";
                    editor.putString("code", Code).commit();
                } else if (teamMember > 1 || otherProfessional > 1) {
                    Code = "ICC PN";
                    editor.putString("code", Code).commit();
                } else if (teamMember > 1 && otherProfessional + friends + familyMembers == 0) {
                    Code = "ICC PN";
                    editor.putString("code", Code).commit();
                } else {
                    Code = "IHBS PN";
                    editor.putString("code", Code).commit();
                }

                editor.putString("clientname", clientName).commit();
                editor.putString("a2street", entryAddress2Street.getText().toString()).commit();
                editor.putString("a2city", entryAddress2City.getText().toString()).commit();
                editor.putString("a2zip", entryAddress2Zip.getText().toString()).commit();
                editor.putString("a2state", entryAddress2State.getText().toString()).commit();
                editor.putInt("other", otherProfessional).commit();
                editor.putInt("friends", friends).commit();
                getLatLngofAddress1 = entryAddress1City.getText().toString();
                getLatLngofAddress2 = entryAddress2City.getText().toString();
                getLatLng(getLatLngofAddress1, getLatLngofAddress2);
                if (test == 1) {
                    texteffectbutton = textPreviewIntroduction.getText().toString();
                    StringBuilder builder = new StringBuilder(texteffectbutton);
                    int lastindex = texteffectbutton.lastIndexOf(",");
                    builder.replace(lastindex, lastindex + 1, ".");
                    button.setVisibility(View.VISIBLE);
                    editor.putString("back", builder.toString()).commit();
                    Fragment fragment = new GoalsFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("back", builder.toString());
                    bundle.putString("clientName", clientName);
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment).commit();
                } else if (test == 2) {
                    texteffectbutton = textPreviewIntroduction.getText().toString();
                    StringBuilder builder2 = new StringBuilder(texteffectbutton);
                    int lastindex = texteffectbutton.lastIndexOf(",");
                    builder2.replace(lastindex, lastindex + 1, ".");
                    button.setVisibility(View.VISIBLE);
                    int last = texteffectbutton.lastIndexOf(", the");
                    builder2.replace(last, last + 1, " and");
                    editor.putString("back", builder2.toString()).commit();
                    Fragment fragment = new GoalsFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("back", builder2.toString());
                    bundle.putString("clientName", clientName);
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment).commit();
                } else if (test > 2) {
                    texteffectbutton = textPreviewIntroduction.getText().toString();
                    StringBuilder builder2 = new StringBuilder(texteffectbutton);
                    int lastindex = texteffectbutton.lastIndexOf(",");
                    builder2.replace(lastindex, lastindex + 1, ".");
                    button.setVisibility(View.VISIBLE);
                    int last = texteffectbutton.lastIndexOf(", the");
                    builder2.replace(last, last + 1, ", and");
                    editor.putString("back", builder2.toString()).commit();
                    Fragment fragment = new GoalsFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("back", builder2.toString());
                    bundle.putString("clientName", clientName);
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment).commit();
                } else {

                }
            }
        });


        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);
    }

    public void getLatLng(String address, String address2) {
        GeocodingLocation locationAddress = new GeocodingLocation();
        locationAddress.getAddressFromLocation(address,
                getActivity(), new GeocoderHandler());

        GeocodingLocation geocodingLocation = new GeocodingLocation();
        geocodingLocation.getAddressFromLocation2(address2, getActivity(), new GeocoderHandler2());
    }


    private class GeocoderHandler extends Handler {
        @Override
        public void handleMessage(Message message) {
            String locationAddress;
            String lat, lng;
            Double latD, lngD;
            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    locationAddress = bundle.getString("address");
                    break;
                default:
                    locationAddress = null;
            }
            latlngaddress1 = locationAddress;
            Log.d("zmaAddress", locationAddress);
            lat = sharedPreferences.getString("lat", "");
            lng = sharedPreferences.getString("lng", "");

        }
    }

    private class GeocoderHandler2 extends Handler {
        @Override
        public void handleMessage(Message message) {
            String locationAddress2;
            String lat2, lng2;
            Double lat2D, lng2D;
            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    locationAddress2 = bundle.getString("address2");
                    break;
                default:
                    locationAddress2 = null;
            }
            Log.d("zmaAddress2", locationAddress2);
            lat2 = sharedPreferences.getString("lat2", "");
            lng2 = sharedPreferences.getString("lng2", "");


        }
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.toggleButton:
                customActionBar();
                break;
            case R.id.toggleButton2:

                customActionBar();
                break;
            case R.id.toggleButtonTherapist:

                customActionBar();
                break;
            case R.id.toggleButtonParentPartner:

                customActionBar();
                break;
            case R.id.toggleButtonCFS:
                customActionBar();
                break;
            case R.id.toggleButtonFacilitator:

                customActionBar();
                break;
            case R.id.toggleButtonClient:

                customActionBar();
                break;
            case R.id.button3:

                customActionBar();
                break;
            case R.id.button4:

                customActionBar();
                break;
            case R.id.buttonAddPerson:

                customActionBar();
                break;
            case R.id.toggleButton1122:
                customActionBar();
                break;
            case R.id.toggleButton12:
                customActionBar();
                break;

            default:
                break;
        }

    }

}
