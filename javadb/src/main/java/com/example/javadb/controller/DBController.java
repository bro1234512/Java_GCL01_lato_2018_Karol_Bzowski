package com.example.javadb.controller;

import com.example.javadb.app.app;
import com.example.javadb.entity.Data;
import com.example.javadb.entity.Model;
import com.example.javadb.entity.Producent;
import com.example.javadb.entity.Samochod;
import com.example.javadb.interFaces.ModelInt;
import com.example.javadb.interFaces.ProducentInt;
import com.example.javadb.interFaces.SamochodInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.sql.*;
import java.util.List;

@Controller
public class DBController {

    @Autowired
    private SamochodInt samochodInt;

    @Autowired
    private ProducentInt producentInt;

    @Autowired
    private ModelInt modelInt;

    @GetMapping("/panel")
    public ModelAndView panel()
    {
        ModelAndView modelAndView = new ModelAndView("panel");
        modelAndView.addObject("producentList",producentInt.findAll());
        modelAndView.addObject("modelList",modelInt.findAll());
        modelAndView.addObject("app", new app());   return modelAndView;
    }

    @PostMapping("/addSamochod")
    @ResponseBody
    public String addSamochod(String nazwa, String opis,@ModelAttribute("app") app app)
    {
        try {
            Samochod samochod = new Samochod(nazwa, opis, app.getProducent().getIdProducent(), app.getModel().getIdModel());

            samochodInt.save(samochod);
        }
        catch (Exception e)
        {
            return "Error adding Samochod!";
        }
        return "Successfully added Samochod "+nazwa+"!";
    }


    @PostMapping("/deleteSamochodById")
    @ResponseBody
    public String deleteSamochodById(long id) {

        Samochod samochod;

        if (samochodInt.findById(id).isPresent()) {
            samochod = samochodInt.findById(id).get();
        }
        else
            return "Samochod doesn't exist!";

        try {
            samochodInt.delete(samochod);
        }
        catch (Exception ex) {
            return "Error deleting Samochod!";
        }
        return "Successfully deleted Samochod with id "+id+"!";
    }

    @PostMapping("/getSamochodById")
    @ResponseBody
    public ModelAndView getSamochodById(long id) {

        Samochod samochod = new Samochod("Not found", "Not found", -1L, -1L);
        samochod.setIdSamochod((long)-1);

        if (samochodInt.findById(id).isPresent()) {
            samochod = samochodInt.findById(id).get();
        }

        return new ModelAndView("getSamochod", "samochod", samochod);
    }

    @PostMapping("/getSamochodByName")
    public ModelAndView getSamochodByName(String nazwa) {
        return new ModelAndView("getSamochod","samochod",samochodInt.findAllByNazwa(nazwa));
    }

    @PostMapping("/updateSamochod")
    @ResponseBody
    public String updateSamochod(Long idSamochod, String nazwa, String opis,@ModelAttribute("app") app app1) {
        try {

            if(!samochodInt.findById(idSamochod).isPresent())
                return "Samochod with id "+idSamochod+" doesn't exist!";

            Samochod samochod = samochodInt.findById(idSamochod).get();
            samochod.setNazwa(nazwa);
            samochod.setOpis(opis);
            samochod.setIdProducent(app1.getProducent().getIdProducent());
            samochod.setIdModel(app1.getModel().getIdModel());
            samochodInt.save(samochod);

        }
        catch (Exception e)
        {
            return "Error uploading Samochod!";
        }
        return "Successfully uploaded Samochod "+nazwa+"!";
    }

    @PostMapping("/showSamochods")
    public ModelAndView showSamochods()
    {
        return new ModelAndView("showSamochody","SamochodList", samochodInt.findAll());
    }

    @PostMapping("/addProducent")
    @ResponseBody
    public String addCategory(String nazwa, String opis)
    {
        Producent test_category = producentInt.findByNazwa(nazwa);
        if(test_category != null)
            return "This category exists!";

        try {
            Producent producent = new Producent(nazwa, opis);
            producentInt.save(producent);
        }
        catch (Exception e)
        {
            return "Error adding category!";
        }
        return "Successfully added category "+nazwa+"!";
    }

    @PostMapping("/deleteProducentById")
    @ResponseBody
    public String deleteCategoryById(Long idProducent, String only_empty)
    {
        Producent producent;
        if (producentInt.findById(idProducent).isPresent()) {
            producent = producentInt.findById(idProducent).get();
        }
        else
            return "Category doesn't exist!";

        List<Samochod> SamochodList = samochodInt.findAllByIdProducent(idProducent);
        if(SamochodList.isEmpty()) {
            producentInt.delete(producent);
            return "Successfully deleted category with id "+idProducent+"!";
        }
        else if (only_empty.equals("false"))
        {
            for (Samochod p : SamochodList)
            {
                p.setIdProducent(null);
            }
            producentInt.delete(producent);
            return "Successfully deleted category with id "+idProducent+"!";
        }

        return "Cannot delete category with id "+idProducent+"!";

    }

    @PostMapping("/showProducentow")
    public ModelAndView showCategories()
    {
        return new ModelAndView("showProducentow","producentList", producentInt.findAll());
    }

    @PostMapping("/addModel")
    @ResponseBody
    public String addProducer(String nazwa, String opis)
    {
        Model test_producer = modelInt.findByNazwa(nazwa);
        if(test_producer != null)
            return "This producer exists!";

        try {
            Model model = new Model(nazwa, opis);
            modelInt.save(model);
        }
        catch (Exception e)
        {
            return "Error adding producer!";
        }
        return "Successfully added producer "+nazwa+"!";
    }

    @PostMapping("/deleteModelById")
    @ResponseBody
    public String deleteProducerById(Long idModel, String only_empty)
    {
        Model model;
        if (modelInt.findById(idModel).isPresent()) {
           model = modelInt.findById(idModel).get();
        }
        else
            return "Category doesn't exist!";

        List<Samochod> SamochodList = samochodInt.findAllByIdModel(idModel);
        if(SamochodList.isEmpty()) {
            modelInt.delete(model);
            return "Successfully deleted producer with id "+idModel+"!";
        }
        else if (only_empty.equals("false"))
        {
            for (Samochod p : SamochodList)
            {
                p.setIdModel(null);
            }
            modelInt.delete(model);
            return "Successfully deleted producer with id "+idModel+"!";
        }

        return "Cannot delete producer with id "+idModel+"!";

    }

    @PostMapping("/showModele")
    public ModelAndView showProducers()
    {
        return new ModelAndView("showModele","modelList", modelInt.findAll());
    }

    @PostMapping("/addData")
    @ResponseBody
    public String addData(Long id, String nazwa, String opis)
    {
        try {
            String URL = "jdbc:mysql://localhost:3306/javadb";
            Connection conn = DriverManager.getConnection(URL, "root", "razdwatrzy");
            Data data = new Data(id, nazwa, opis);

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO datas(`iddata`, `opis`) VALUES (?,?)");
            pstmt.setLong(1, id);
            pstmt.setObject(2, data);
            pstmt.executeUpdate();
            pstmt.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return "Error!";
        }
        return "Data added!";
    }

    @PostMapping("/showData")
    public ModelAndView showData(Long dataId)
    {
        Data data = null;
        try {
            String URL = "jdbc:mysql://localhost:3306/javadb";
            Connection conn = DriverManager.getConnection(URL, "root", "razdwatrzy");

            PreparedStatement pstmt = conn.prepareStatement("SELECT `opis` FROM datas WHERE iddata=?");
            pstmt.setLong(1, dataId);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            byte[] buf = rs.getBytes("desc");
            ObjectInputStream objectIn = null;
            if (buf != null)
                objectIn = new ObjectInputStream(new ByteArrayInputStream(buf));
            Object object = objectIn.readObject();
            data = (Data)object;
            rs.close();
            pstmt.close();
        }
        catch (SQLException | IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        return new ModelAndView("showDatas", "data", data);
    }
}
