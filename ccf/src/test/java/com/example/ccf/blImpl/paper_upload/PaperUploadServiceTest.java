package com.example.ccf.blImpl.paper_upload;
import com.example.ccf.vo.Private_paper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaperUploadServiceTest {
    @Autowired
    private PaperUploadServiceImpl paperUploadService;
    @Test
    public void test(){
        Private_paper u=new Private_paper();
        List<String> authors=new ArrayList<>();
        authors.add("xiao");
        authors.add("ke");
        u.setAuthors(authors);
        u.setTitle("Echidna: effective, usable, and fast fuzzing for smart contracts ");
        u.setAbstracts("Ethereum smart contracts---autonomous programs that run on a blockchain---often control transactions of financial and intellectual property. Because of the critical role they play, smart contracts need complete, comprehensive, and effective test generation. This paper introduces an open-source smart contract fuzzer called Echidna that makes it easy to automatically generate tests to detect violations in assertions and custom properties. Echidna is easy to install and does not require a complex configuration or deployment of contracts to a local blockchain. It offers responsive feedback, captures many property violations, and its default settings are calibrated based on experimental data. To date, Echidna has been used in more than 10 large paid security audits, and feedback from those audits has driven the features and user experience of Echidna, both in terms of practical usability (e.g., smart contract frameworks like Truffle and Embark) and test generation strategies. Echidna aims to be good at finding real bugs in smart contracts, with minimal user effort and maximal speed.");
        u.setDoi("10.1145/3395363.3404366");
        u.setCitation(0);
        u.setBook_title("");
        u.setPages("");
        u.setPublisher("ACM");
        u.setYear("2017");
        u.setUrl("");
        u.setTime("");
        u.setBib_url("");
        u.setBib_source("");
        System.out.println(paperUploadService.paper_check(u));
       // System.out.println(paperUploadService.private_paper_upload(u,3).getContent());
//        System.out.println(paperUploadService.team_paper_upload(u,2).getContent());
    }
}
