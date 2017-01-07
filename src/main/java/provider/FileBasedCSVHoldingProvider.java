package provider;

import entities.AssetCodeType;
import entities.Holding;
import entities.HoldingProvider;
import entities.Instrument;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by vikas on 1/7/2017.
 */
public class FileBasedCSVHoldingProvider implements HoldingProvider{

    private String holdingFileName;

    private List<Holding> holdings = new ArrayList<>();

    public FileBasedCSVHoldingProvider(String holdingFileName) {
        this.holdingFileName = holdingFileName;
    }

    public FileBasedCSVHoldingProvider() {
    }

    @Override
    public List<Holding> getHoldings() {
        if(holdings == null || holdings.size() == 0)
            loadHoldings();
        return holdings;
    }

    public void setHoldingFileName(String holdingFileName) {
        this.holdingFileName = holdingFileName;
    }

    private void loadHoldings() {
        File f = new File(holdingFileName);

        try {
            Scanner scanner = new Scanner(new FileInputStream(f));

            // ignore header
            System.out.println("Portfolio file header:\n"+scanner.nextLine());

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();

                List<String> fld = Arrays.asList(line.split(","));

                Instrument i = new Instrument(fld.get(1));
                i.setIsin(fld.get(2));
                i.setName(fld.get(3));
                i.setIdentifier(AssetCodeType.ICICIDirectTicker, fld.get(0));

                Holding h = new Holding(i, Long.parseLong(fld.get(4)), Double.parseDouble(fld.get(5)));
                holdings.add(h);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Could not open file "+f.getAbsolutePath());
            System.exit(-1);
        }

        System.out.println("Total "+holdings.size()+" holdings loaded in the portfolio");
    }
}
