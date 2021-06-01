package codingame.spreadshits;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class SolutionTest {


    /**
     * SUB $33 $64
     * ADD $60 $60
     * ADD $61 $61
     * SUB $76 $80
     * SUB $25 $59
     * ADD $58 $28
     * ADD $88 $59
     * ADD $32 $32
     * ADD $83 $21
     * ADD $69 $39
     * ADD $57 $64
     * ADD $26 $26
     * ADD $1 $1
     * SUB $62 $68
     * ADD $73 $1
     * ADD $50 $27
     * SUB $24 $2
     * ADD $14 $12
     * ADD $10 $89
     * SUB $67 $35
     * ADD $58 $58
     * ADD $7 $7
     * SUB $0 $89
     * ADD $20 $20
     * SUB $43 $61
     * SUB $53 $11
     * ADD $37 $37
     * ADD $82 $47
     * ADD $90 $2
     * ADD $89 $89
     * ADD $85 $85
     * SUB $91 $47
     * ADD $69 $69
     * SUB $46 $86
     * SUB $42 $20
     * ADD $12 $12
     * ADD $56 $8
     * ADD $72 $72
     * ADD $9 $32
     * ADD $30 $77
     * ADD $80 $48
     * ADD $79 $81
     * SUB $16 $58
     * SUB $44 $56
     * SUB $63 $21
     * ADD $20 $5
     * SUB $49 $81
     * ADD $54 $54
     * ADD $29 $18
     * SUB $34 $23
     * ADD $47 $47
     * SUB $74 $32
     * SUB $17 $72
     * SUB $71 $26
     * ADD $59 $59
     * ADD $15 $68
     * ADD $21 $21
     * ADD $86 $41
     * ADD $2 $2
     * ADD $11 $11
     * ADD $80 $80
     * ADD $56 $56
     * SUB $31 $50
     * SUB $51 $7
     * ADD $86 $86
     * ADD $72 $35
     * SUB $75 $30
     * SUB $70 $12
     * ADD $50 $50
     * ADD $30 $30
     * SUB $84 $1
     * SUB $52 $37
     * VALUE 1 _
     * ADD $40 $60
     * SUB $66 $69
     * SUB $13 $85
     * SUB $22 $29
     * ADD $55 $85
     * ADD $37 $65
     * ADD $23 $45
     * ADD $29 $29
     * ADD $23 $23
     * ADD $54 $6
     * ADD $38 $7
     * SUB $3 $60
     * ADD $68 $68
     * ADD $81 $81
     * ADD $78 $26
     * ADD $87 $11
     * ADD $64 $64
     * ADD $61 $36
     * SUB $4 $54
     */
    @Test
    public void execute() {

        String testData = "SUB $33 $64\n" +
                "ADD $60 $60\n" +
                "ADD $61 $61\n" +
                "SUB $76 $80\n" +
                "SUB $25 $59\n" +
                "ADD $58 $28\n" +
                "ADD $88 $59\n" +
                "ADD $32 $32\n" +
                "ADD $83 $21\n" +
                "ADD $69 $39\n" +
                "ADD $57 $64\n" +
                "ADD $26 $26\n" +
                "ADD $1 $1\n" +
                "SUB $62 $68\n" +
                "ADD $73 $1\n" +
                "ADD $50 $27\n" +
                "SUB $24 $2\n" +
                "ADD $14 $12\n" +
                "ADD $10 $89\n" +
                "SUB $67 $35\n" +
                "ADD $58 $58\n" +
                "ADD $7 $7\n" +
                "SUB $0 $89\n" +
                "ADD $20 $20\n" +
                "SUB $43 $61\n" +
                "SUB $53 $11\n" +
                "ADD $37 $37\n" +
                "ADD $82 $47\n" +
                "ADD $90 $2\n" +
                "ADD $89 $89\n" +
                "ADD $85 $85\n" +
                "SUB $91 $47\n" +
                "ADD $69 $69\n" +
                "SUB $46 $86\n" +
                "SUB $42 $20\n" +
                "ADD $12 $12\n" +
                "ADD $56 $8\n" +
                "ADD $72 $72\n" +
                "ADD $9 $32\n" +
                "ADD $30 $77\n" +
                "ADD $80 $48\n" +
                "ADD $79 $81\n" +
                "SUB $16 $58\n" +
                "SUB $44 $56\n" +
                "SUB $63 $21\n" +
                "ADD $20 $5\n" +
                "SUB $49 $81\n" +
                "ADD $54 $54\n" +
                "ADD $29 $18\n" +
                "SUB $34 $23\n" +
                "ADD $47 $47\n" +
                "SUB $74 $32\n" +
                "SUB $17 $72\n" +
                "SUB $71 $26\n" +
                "ADD $59 $59\n" +
                "ADD $15 $68\n" +
                "ADD $21 $21\n" +
                "ADD $86 $41\n" +
                "ADD $2 $2\n" +
                "ADD $11 $11\n" +
                "ADD $80 $80\n" +
                "ADD $56 $56\n" +
                "SUB $31 $50\n" +
                "SUB $51 $7\n" +
                "ADD $86 $86\n" +
                "ADD $72 $35\n" +
                "SUB $75 $30\n" +
                "SUB $70 $12\n" +
                "ADD $50 $50\n" +
                "ADD $30 $30\n" +
                "SUB $84 $1\n" +
                "SUB $52 $37\n" +
                "VALUE 1 _\n" +
                "ADD $40 $60\n" +
                "SUB $66 $69\n" +
                "SUB $13 $85\n" +
                "SUB $22 $29\n" +
                "ADD $55 $85\n" +
                "ADD $37 $65\n" +
                "ADD $23 $45\n" +
                "ADD $29 $29\n" +
                "ADD $23 $23\n" +
                "ADD $54 $6\n" +
                "ADD $38 $7\n" +
                "SUB $3 $60\n" +
                "ADD $68 $68\n" +
                "ADD $81 $81\n" +
                "ADD $78 $26\n" +
                "ADD $87 $11\n" +
                "ADD $64 $64\n" +
                "ADD $61 $36\n" +
                "SUB $4 $54";
        String[] cells = new String[92];
        int i =0;
        for (String s: testData.split("\n")){
            String[] temp = s.split(" ");
            if ("VALUE".equals(temp[0])){
                cells[i] = temp[1];
            } else {
                cells[i] = temp[0] + " " + temp[1] + " " + temp[2];
            }
            i++;
        }
        long start = Instant.now().getEpochSecond();
        Solution.execute(cells, 92);
        System.out.println("TOTAL TIME " + (Instant.now().getEpochSecond() - start));
    }
}
