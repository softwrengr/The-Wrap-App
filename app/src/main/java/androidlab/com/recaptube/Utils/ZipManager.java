package androidlab.com.recaptube.Utils;

/**
 * Created by Sanjay on 22/5/18.
 */

import android.os.Environment;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipManager {
    private List<String> fileList;
    String SOURCE_FOLDER = Environment.getExternalStorageDirectory().getPath() + "/.tmpDocx/";

    public ZipManager() {
        fileList = new ArrayList<String>();
    }

    public boolean zipIt(String zipFile, String Fname, String CaregiverName, String TherapistName, String ParentPartnerName, String FacilitatorName, String CFSName, String SupervisorName, String NonNegotiables, String ClientWorries, String ClientRules, String caregiverGoal, String clientGoal, String dateVal, String startTime, String endTime, String ClientID, String ClientDOB , String Lname, String calledFrom, String[] Wages) {
//        public boolean zipIt(String zipFile, String Fname, String TherapistName, String dateAndTimeVal, String ClientID, String ClientDOB , String Lname, String CaregiverWages, String ClientWages, String SpouseWages, String calledFrom) {
        byte[] buffer = new byte[2048];
        try {
            FileOutputStream fos = new FileOutputStream(zipFile);
            ZipOutputStream zos = new ZipOutputStream(fos);
            for (String file : this.fileList) {
                System.out.println("File Added : " + file);
                ZipEntry ze = new ZipEntry(file);
                zos.putNextEntry(ze);
                if (file.equals("word/document.xml")) {
                    InputStream in1 = new FileInputStream(new File(SOURCE_FOLDER + file));
                    BufferedReader reader1 = new BufferedReader(new InputStreamReader(in1));
                    StringBuilder out1 = new StringBuilder();
                    String line;
                    if (calledFrom.equals("CFTMIN")) {
                        while ((line = reader1.readLine()) != null) {
                            String str = line.replace("ClientFirstName", Fname);
                            String str1 = str.replace("TherapistName", TherapistName);
                            String str2 = str1.replace("FacilitatorName", FacilitatorName);
                            String str3 = str2.replace("CFSName", CFSName);
                            String str4 = str3.replace("SupervisorName", SupervisorName);
                            String str5 = str4.replace("NonNegotiables", NonNegotiables);
                            String str6 = str5.replace("CaregiverName", CaregiverName);
                            String str7 = str6.replace("ClientWorries", ClientWorries);
                            String str8 = str7.replace("ClientRules", ClientRules);
                            String str9 = str8.replace("CaregiverGoal", caregiverGoal);
                            String str10 = str9.replace("ClientGoal", clientGoal);
                            String str11 = str10.replace("DateFormat", dateVal);
                            String str12 = str11.replace("StartTime", startTime);
                            String str13 = str12.replace("EndTime", endTime);
                            String str14 = str13.replace("ParentPartnerName", ParentPartnerName);
                            String str15 = str14.replace("ClientLastName", Lname);
                            out1.append(str15);
                        }
                        String finalString = out1.toString();
                        zos.write(finalString.getBytes());
                    }
                    else if (calledFrom.equals("OMA3")){
                        while ((line = reader1.readLine()) != null) {
                            String s = line.replace("ClientID", ClientID);
                            String s1 = s.replace("ClientDOB", ClientDOB);
                            String s2 = s1.replace("ClientFirstName", Fname);
                            String s3 = s2.replace("ClientLastName", Lname);
                            String s4 = s3.replace("P1b01", Wages[0]);
                            String s5 = s4.replace("P1b02", Wages[1]);
                            String s6 = s5.replace("P1b03", Wages[2]);
                            String s7 = s6.replace("P1b04", Wages[3]);
                            String s8 = s7.replace("P1b05", Wages[4]);
                            String s9 = s8.replace("P1b06", Wages[5]);
                            String s10 = s9.replace("P1b07", Wages[6]);
                            String s11 = s10.replace("P1b08", Wages[7]);
                            String s12 = s11.replace("P1b09", Wages[8]);
                            String s13 = s12.replace("P1b10", Wages[9]);
                            String s14 = s13.replace("P1b11", Wages[10]);
                            String s15 = s14.replace("P1b12", Wages[11]);
                            String s16 = s15.replace("P1b13", Wages[12]);
                            String s17 = s16.replace("P1b14", Wages[13]);
                            String s18 = s17.replace("P1b15", Wages[14]);
                            String s19 = s18.replace("P1b16", Wages[15]);
                            String s20 = s19.replace("P1b17", Wages[16]);
                            String s21 = s20.replace("P1b18", Wages[17]);
                            String s22 = s21.replace("P1b19", Wages[18]);
                            out1.append(s22);
                        }
                        String finalString1 = out1.toString();
                        zos.write(finalString1.getBytes());
                    }
                } else {
                    FileInputStream in =
                            new FileInputStream(SOURCE_FOLDER + file);
                    int len;
                    StringBuilder stringBuilder = new StringBuilder();

                    while ((len = in.read(buffer)) > 0) {
                        zos.write(buffer, 0, len);
                    }
                    in.close();
                }


            }
            zos.closeEntry();
            //remember close it
            zos.close();
            System.out.println("Done");
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
        finally {
            File dir = new File(SOURCE_FOLDER);
            if (dir.isDirectory())
            {
                String[] children = dir.list();
                for (int i = 0; i < children.length; i++)
                {
                    new File(dir, children[i]).delete();
                }
            }
        }
        return true;
    }

    /**
     * Traverse a directory and get all files,
     * and add the file into fileList
     *
     * @param node file or directory
     */
    public void generateFileList(File node) {

//add file only
        if (node.isFile()) {
            fileList.add(generateZipEntry(node.getAbsoluteFile().toString()));
        }

        if (node.isDirectory()) {
            String[] subNote = node.list();
            for (String filename : subNote) {
                generateFileList(new File(node, filename));
            }
        }

    }

    /**
     * Format the file path for zip
     *
     * @param file file path
     * @return Formatted file path
     */
    private String generateZipEntry(String file) {
        return file.substring(SOURCE_FOLDER.length(), file.length());
    }

    public boolean extractZip(String pathOfZip, String pathToExtract, boolean extraDir) {
        int BUFFER_SIZE = 1024;
        int size;
        byte[] buffer = new byte[BUFFER_SIZE];
        try {
            File f = new File(pathToExtract);
            if (!f.isDirectory()) {
                f.mkdirs();
            }
            Log.i("SJA", "pathOfZip:" + pathOfZip);
            Log.i("SJA", "pathToExtract:" + pathToExtract);
            ZipInputStream zin = new ZipInputStream(new BufferedInputStream(new FileInputStream(pathOfZip), BUFFER_SIZE));
            try {
                File _rels = new File(pathToExtract + "_rels");
                if (!_rels.isDirectory()) {
                    _rels.mkdirs();
                }
                File docProps = new File(pathToExtract + "docProps");
                if (!docProps.isDirectory()) {
                    docProps.mkdirs();
                }
                File wordDir = new File(pathToExtract + "word");
                if (!wordDir.isDirectory()) {
                    wordDir.mkdirs();
                }
                File word_RelsDir = new File(pathToExtract + "/word/_rels");
                if (!word_RelsDir.isDirectory()) {
                    word_RelsDir.mkdirs();
                }
                File wordglossaryDir = new File(pathToExtract + "/word/glossary");
                if (!wordglossaryDir.isDirectory()) {
                    wordglossaryDir.mkdirs();
                }
                File wordglossar_relsyDir = new File(pathToExtract + "/word/glossary/_rels");
                if (!wordglossar_relsyDir.isDirectory()) {
                    wordglossar_relsyDir.mkdirs();
                }
                File wordthemeDir = new File(pathToExtract + "/word/theme");
                if (!wordthemeDir.isDirectory()) {
                    wordthemeDir.mkdirs();
                }
                if (extraDir == true) {
                    File customXmlDir = new File(pathToExtract + "/customXml");
                    if (!customXmlDir.isDirectory()) {
                        customXmlDir.mkdirs();
                    }
                    File customXmlRelsDir = new File(pathToExtract + "/customXml/_rels");
                    if (!customXmlRelsDir.isDirectory()) {
                        customXmlRelsDir.mkdirs();
                    }
                }
                ZipEntry ze = null;
                while ((ze = zin.getNextEntry()) != null) {
                    String path = pathToExtract + ze.getName();
                    if (ze.isDirectory()) {
                        File unzipFile = new File(path);
                        if (!unzipFile.isDirectory()) {
                            unzipFile.mkdirs();
                        }
                    } else {
                        FileOutputStream out = new FileOutputStream(path, false);
                        BufferedOutputStream fout = new BufferedOutputStream(out, BUFFER_SIZE);
                        try {
                            while ((size = zin.read(buffer, 0, BUFFER_SIZE)) != -1) {
                                fout.write(buffer, 0, size);
                            }
                            zin.closeEntry();
                        } catch (Exception e) {
                            Log.e("Exception", "Unzip exception 1:" + e.toString());
                        } finally {
                            fout.flush();
                            fout.close();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("Exception", "Unzip exception2 :" + e.toString());
                return false;
            } finally {
                zin.close();
            }
        } catch (Exception e) {
            Log.e("Exception", "Unzip exception :" + e.toString());
            return false;
        }
        return true;
    }
}
