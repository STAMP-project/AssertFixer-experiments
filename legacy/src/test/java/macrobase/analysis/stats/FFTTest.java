package macrobase.analysis.stats;


import macrobase.conf.MacroBaseConf;
import macrobase.datamodel.Datum;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class FFTTest {

    @Test
    public void testFFTTransform() throws Exception {
        double[] test_input =  {2.24120611573000,2.12215703941000,1.75273899872000,1.33988834232000,0.944127790619000,0.740475575456000,0.688064246951000,0.647745146434000,0.684477804740000,0.905214502349000,1.11429962551000,1.35319232934000,1.54059522739000,1.78246688712000,2.17183901182000,2.55432971168000,2.92949308220000,3.20230988502000,3.42596923011000,3.61949923094000,3.78276832765000,3.87181704262000,3.86482056309000,3.68006472992000,0,0,0,0,0,0,0,0};
        double[] expected_return = {50.959560447139005,0.0, -19.18116056949066,5.501342136595359,8.4180172341819,-16.05988961755714,9.257726525809472,-1.4007288223010215,-0.1263026558020457,0.9511833120557635,-2.268687435900532,-4.543228417029076,3.591125444534933,-4.629703914058681,3.0904615384885172,0.19497138213139342,-0.8950633278720002,0.5702785586589999,-0.27121650007953746,-2.7675753532010674,3.000682832479642,-1.8870566655000403,2.099339190479186,1.1612853788078912,-0.6983260301759526,0.0877513770137655,0.5448230754788493,-2.1055528083622272,2.9350600615635263,-0.5720388054824936,1.222418443454704,1.6052800572847277,-0.6787603980789996,0.0,1.2224184434547087,-1.6052800572847288,2.935060061563525,0.5720388054824976,0.5448230754788472,2.105552808362229,-0.6983260301759526,-0.08775137701376556,2.099339190479185,-1.1612853788078894,3.00068283247964,1.8870566655000391,-0.27121650007953546,2.7675753532010647,-0.8950633278720002,-0.5702785586589999,3.0904615384885172,-0.19497138213139342,3.5911254445349354,4.629703914058684,-2.2686874359005333,4.543228417029075,-0.12630265580204597,-0.9511833120557633,9.25772652580947,1.4007288223010232,8.418017234181896,16.059889617557136,-19.181160569490658,-5.501342136595361};
        List<Datum> data = new ArrayList<>();
        Datum d = new Datum(new ArrayList<>(), new ArrayRealVector(test_input));
        data.add(d);

        FFT fft = new FFT(new MacroBaseConf());
        fft.consume(data);
        List<Datum> transformed = fft.getStream().drain();
        for (Datum td: transformed){
            double[] val = td.metrics().toArray();
            assertEquals(64,val.length);
            assertArrayEquals(expected_return, val, 1e-5);
        }
    }
    @Test
    public void testFFTTransformNotPowTwo() throws Exception {
        double[] test_input =  {2.24120611573000,2.12215703941000,1.75273899872000,1.33988834232000,0.944127790619000,0.740475575456000,0.688064246951000,0.647745146434000,0.684477804740000,0.905214502349000,1.11429962551000,1.35319232934000,1.54059522739000,1.78246688712000,2.17183901182000,2.55432971168000,2.92949308220000,3.20230988502000,3.42596923011000,3.61949923094000,3.78276832765000,3.87181704262000,3.86482056309000,3.68006472992000};
        double[] expected_return = {50.959560447139005,0.0, -19.18116056949066,5.501342136595359,8.4180172341819,-16.05988961755714,9.257726525809472,-1.4007288223010215,-0.1263026558020457,0.9511833120557635,-2.268687435900532,-4.543228417029076,3.591125444534933,-4.629703914058681,3.0904615384885172,0.19497138213139342,-0.8950633278720002,0.5702785586589999,-0.27121650007953746,-2.7675753532010674,3.000682832479642,-1.8870566655000403,2.099339190479186,1.1612853788078912,-0.6983260301759526,0.0877513770137655,0.5448230754788493,-2.1055528083622272,2.9350600615635263,-0.5720388054824936,1.222418443454704,1.6052800572847277,-0.6787603980789996,0.0,1.2224184434547087,-1.6052800572847288,2.935060061563525,0.5720388054824976,0.5448230754788472,2.105552808362229,-0.6983260301759526,-0.08775137701376556,2.099339190479185,-1.1612853788078894,3.00068283247964,1.8870566655000391,-0.27121650007953546,2.7675753532010647,-0.8950633278720002,-0.5702785586589999,3.0904615384885172,-0.19497138213139342,3.5911254445349354,4.629703914058684,-2.2686874359005333,4.543228417029075,-0.12630265580204597,-0.9511833120557633,9.25772652580947,1.4007288223010232,8.418017234181896,16.059889617557136,-19.181160569490658,-5.501342136595361};
        List<Datum> data = new ArrayList<>();
        Datum d = new Datum(new ArrayList<>(), new ArrayRealVector(test_input));
        data.add(d);

        FFT fft = new FFT(new MacroBaseConf());
        fft.consume(data);
        List<Datum> transformed = fft.getStream().drain();
        for (Datum td: transformed){
            double[] val = td.metrics().toArray();
            assertEquals(64,val.length);
            assertArrayEquals(expected_return, val, 1e-5);
        }
    }
    @Test
    public void testFFTTransformActualStream() throws Exception {
        int index = 0;
        double[][] test_input = {
                {2.24120611573000, 2.12215703941000, 1.75273899872000, 1.33988834232000, 0.944127790619000, 0.740475575456000, 0.688064246951000, 0.647745146434000, 0.684477804740000, 0.905214502349000, 1.11429962551000, 1.35319232934000, 1.54059522739000, 1.78246688712000, 2.17183901182000, 2.55432971168000, 2.92949308220000, 3.20230988502000, 3.42596923011000, 3.61949923094000, 3.78276832765000, 3.87181704262000, 3.86482056309000, 3.68006472992000},
                {2.24120611573000,2.12215703941000,1.75273899872000,1.33988834232000,0.944127790619000,0.740475575456000,0.688064246951000,0.647745146434000,0.684477804740000,0.905214502349000,1.11429962551000,1.35319232934000,1.54059522739000,1.78246688712000,2.17183901182000,2.55432971168000,2.92949308220000,3.20230988502000,3.42596923011000,3.61949923094000,3.78276832765000,3.87181704262000,3.86482056309000,3.68006472992000,0,0,0,0,0,0,0,0},
                {1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0},
                {-19.18116056949066,5.501342136595359,8.4180172341819,-16.05988961755714,9.257726525809472,-1.4007288223010215,-0.1263026558020457,0.9511833120557635,-2.268687435900532,-4.543228417029076,3.591125444534933}
        };
        double[][] expected_return = {
                {50.959560447139005,0.0, -19.18116056949066,5.501342136595359,8.4180172341819,-16.05988961755714,9.257726525809472,-1.4007288223010215,-0.1263026558020457,0.9511833120557635,-2.268687435900532,-4.543228417029076,3.591125444534933,-4.629703914058681,3.0904615384885172,0.19497138213139342,-0.8950633278720002,0.5702785586589999,-0.27121650007953746,-2.7675753532010674,3.000682832479642,-1.8870566655000403,2.099339190479186,1.1612853788078912,-0.6983260301759526,0.0877513770137655,0.5448230754788493,-2.1055528083622272,2.9350600615635263,-0.5720388054824936,1.222418443454704,1.6052800572847277,-0.6787603980789996,0.0,1.2224184434547087,-1.6052800572847288,2.935060061563525,0.5720388054824976,0.5448230754788472,2.105552808362229,-0.6983260301759526,-0.08775137701376556,2.099339190479185,-1.1612853788078894,3.00068283247964,1.8870566655000391,-0.27121650007953546,2.7675753532010647,-0.8950633278720002,-0.5702785586589999,3.0904615384885172,-0.19497138213139342,3.5911254445349354,4.629703914058684,-2.2686874359005333,4.543228417029075,-0.12630265580204597,-0.9511833120557633,9.25772652580947,1.4007288223010232,8.418017234181896,16.059889617557136,-19.181160569490658,-5.501342136595361},
                {50.959560447139005,0.0, -19.18116056949066,5.501342136595359,8.4180172341819,-16.05988961755714,9.257726525809472,-1.4007288223010215,-0.1263026558020457,0.9511833120557635,-2.268687435900532,-4.543228417029076,3.591125444534933,-4.629703914058681,3.0904615384885172,0.19497138213139342,-0.8950633278720002,0.5702785586589999,-0.27121650007953746,-2.7675753532010674,3.000682832479642,-1.8870566655000403,2.099339190479186,1.1612853788078912,-0.6983260301759526,0.0877513770137655,0.5448230754788493,-2.1055528083622272,2.9350600615635263,-0.5720388054824936,1.222418443454704,1.6052800572847277,-0.6787603980789996,0.0,1.2224184434547087,-1.6052800572847288,2.935060061563525,0.5720388054824976,0.5448230754788472,2.105552808362229,-0.6983260301759526,-0.08775137701376556,2.099339190479185,-1.1612853788078894,3.00068283247964,1.8870566655000391,-0.27121650007953546,2.7675753532010647,-0.8950633278720002,-0.5702785586589999,3.0904615384885172,-0.19497138213139342,3.5911254445349354,4.629703914058684,-2.2686874359005333,4.543228417029075,-0.12630265580204597,-0.9511833120557633,9.25772652580947,1.4007288223010232,8.418017234181896,16.059889617557136,-19.181160569490658,-5.501342136595361},
                {7.0,0.0,-0.7071067811865475,-0.7071067811865476,2.220446049250313E-16,-1.0,0.7071067811865477,-0.7071067811865474,1.0,0.0,0.7071067811865475,0.7071067811865476,-2.220446049250313E-16,1.0,-0.7071067811865477,0.7071067811865474},
                {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0},
                {-15.86060286490305,0.0,-10.6186593677134,-0.6579298071091086,-17.010975950306786,-1.7747538678363666,-3.3917232505452493,-10.906733263119964,-24.074961502496507,-14.666091202766637,-37.43809777846009,-22.774549410511824,-44.40417311209455,22.49613680120139,-16.20141213764179,24.505160148736927,15.242039951569183,0.0,-16.201412137641785,-24.505160148736923,-44.40417311209454,-22.49613680120139,-37.43809777846009,22.77454941051182,-24.074961502496507,14.666091202766637,-3.3917232505452404,10.906733263119966,-17.010975950306786,1.7747538678363686,-10.618659367713398,0.657929807109106}
        };

        List<Datum> data = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            Datum d = new Datum(new ArrayList<>(), new ArrayRealVector(test_input[i]));
            data.add(d);
        }

        FFT fft = new FFT(new MacroBaseConf());
        fft.consume(data);
        List<Datum> transformed = fft.getStream().drain();
        for (Datum td: transformed){
            double[] val = td.metrics().toArray();
            assertArrayEquals(expected_return[index++], val, 1e-5);
        }

        //testing coverage weirdness
        fft.initialize();
        fft.shutdown();
    }
}
