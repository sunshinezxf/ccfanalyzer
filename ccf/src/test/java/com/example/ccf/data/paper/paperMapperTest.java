package com.example.ccf.data.paper;

import com.example.ccf.bl.PaperService;
import com.example.ccf.data.ConnectTest;
import com.example.ccf.po.InfoPaper;
import com.example.ccf.po.Paper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class paperMapperTest {
    private final static Logger logger= LoggerFactory.getLogger(ConnectTest.class);

    @Autowired
    private PaperService paperService;

    @Test
    public void paperTest(){

        Paper paper=paperService.getPaperById(1);
        String expected="Paper{paper_id=1, title='A programming model for semi-implicit parallelization of static " +
                "analyses', Abstract='Parallelization of static analyses is necessary to scale to real-world " +
                "programs, but it is a complex and difficult task and, therefore, often only done manually for" +
                " selected high-profile analyses. In this paper, we propose a programming model for semi-implicit " +
                "parallelization of static analyses which is inspired by reactive programming. Reusing the " +
                "domain-expert knowledge on how to parallelize anal- yses encoded in the programming framework," +
                " developers do not need to think about parallelization and concurrency issues on their own. The " +
                "programming model supports stateful computations, only requires monotonic computations over lattices, " +
                "and is independent of specific analyses. Our evaluation shows the applicability of the programming " +
                "model to different analyses and the importance of user-selected scheduling strategies. We implemented" +
                " an IFDS solver that was able to outperform a state-of-the-art, specialized parallel IFDS solver" +
                " both in absolute performance and scalability.', doi='10.1145/3395363.3397367', citation=1, " +
                "book_title='{ISSTA} '20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and " +
                "Analysis, Virtual Event, USA, July 18-22, 2020', pages='428--439', publisher='{ACM}', year='2020'," +
                " url='https://doi.org/10.1145/3395363.3397367', time='Wed, 15 Jul 2020 16:06:56 +0200', " +
                "bib_url='https://dblp.org/rec/conf/issta/HelmKKHESM20.bib', bib_source='dblp computer science" +
                " bibliography, https://dblp.org'}";
        assertEquals(expected,paper.toString());

    }

    @Test
    public void InfoPaperTest(){
        InfoPaper infoPaper=paperService.getInfoPaperById(1);
        logger.info(infoPaper.toString());

    }
}
