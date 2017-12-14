package com.example.moocClient;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import java.util.logging.Logger;
import java.util.logging.Level;

import com.google.gson.Gson;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.google.gson.reflect.TypeToken;

@Controller
@RequestMapping("/")
public class MoocClientController {

    private JobEntityRepository jobEntityRepository;

    @Autowired
    public MoocClientController(JobEntityRepository jobEntityRepository) {
        this.jobEntityRepository = jobEntityRepository;

    }


    @RequestMapping(value = "/fail")
    public void fail() {
        throw new RuntimeException();
    }

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(value = HttpStatus.BANDWIDTH_LIMIT_EXCEEDED)
    public String error() {
        return "error";
    }



//-------    Call API
    @RequestMapping(value="job/jobDetail/{id}", method = RequestMethod.POST)
    public String tagList(Model model, @RequestParam("tags") String tag, @PathVariable("id") Integer id) {

        MoocEntity moocEntity = new MoocEntity();

        if (id != null) {
            List<JobEntity> jobDetail = jobEntityRepository.findAllById(id);
            if (jobDetail != null) {
                model.addAttribute("jobDetails", jobDetail);
            }
        }

        if (tag != null) {

            String moocListString = "Let's find local moocs";
            String tagPath = tag.toString().replaceAll(" ","%20");

            try {

                moocListString = getJSON("http://moocservice.us-east-2.elasticbeanstalk.com/moocs/" + tagPath ,
                        10000);

            } finally {

            }

            Gson gson = new Gson();

            List<MoocEntity> results = new ArrayList<>();
            //List<Staff> list = gson.fromJson(json, new TypeToken<List<Staff>>(){}.getType());
            //list.forEach(x -> System.out.println(x));

            results = gson.fromJson(moocListString, new TypeToken<List<MoocEntity>>(){}.getType());


            //List<MoocEntity> moocEntityList = moocEntity.getResults();

            //model.addAttribute("moocs", moocList);
            //return "jobDetail";

            //List<String> jobTags = Arrays.asList(tag.split("\\s*,\\s*"));
            //List<MoocEntity> moocList = new ArrayList<>();

              //          moocList.add(moocEntity);

            List<MoocEntity> moocList = results;
            model.addAttribute("moocs", moocList);



            return "jobDetail";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/")
    public String jobList(Model model) {

        List<JobEntity> jobList = jobEntityRepository.findAll();
        if (jobList != null) {
            model.addAttribute("jobs", jobList);
        }
        return "jobList";
    }


    @RequestMapping(value="job/jobDetail/{id}", method = RequestMethod.GET)
    public String jobDetail(Model model, @PathVariable("id") Integer id) {

        if (id != null) {
            List<JobEntity> jobDetail = jobEntityRepository.findAllById(id);
            if (jobDetail != null) {
                model.addAttribute("jobDetails", jobDetail);
            }
            return "jobDetail";
        } else {
            return "redirect:/jobs";
        }

    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String meetup(Model model) throws IOException {


        List<JobEntity> jobList = jobEntityRepository.findAll();
        if (jobList != null) {
            model.addAttribute("jobs", jobList);
        }

        String meetupList = "Let's find local meetups";

        try {

            meetupList = getJSON("https://api.meetup.com/2/groups?key=5c21234fc612766e5e776337582036&zip=72758&radius=50&topic=SoftwareDev&sign=true",
                    5000);

        } finally {

        }

        Gson gson = new Gson();
        Meetup meetup = gson.fromJson(meetupList, Meetup.class);

        List<Group> meetupGroups = meetup.getResults();

        model.addAttribute("meetups", meetupGroups);
        return "jobList";

    }



    public String getJSON(String url, int timeout) {
        HttpURLConnection c = null;
        try {
            URL u = new URL(url);
            c = (HttpURLConnection) u.openConnection();
            c.setRequestMethod("GET");
            c.setRequestProperty("Content-length", "0");
            c.setUseCaches(false);
            c.setAllowUserInteraction(false);
            c.setConnectTimeout(timeout);
            c.setReadTimeout(timeout);
            c.connect();
            int status = c.getResponseCode();

            switch (status) {
                case 200:
                case 201:
                    BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line+"\n");
                    }
                    br.close();
                    return sb.toString();
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (c != null) {
                try {
                    c.disconnect();
                } catch (Exception ex) {
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

}

