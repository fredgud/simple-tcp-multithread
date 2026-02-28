package simple_tcp_thread_fred2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public Cliente() throws Exception {

        Scanner teclado = new Scanner(System.in);

        // Se hacen al menos 3 llamadas al servidor
        for (int i = 1; i <= 3; i++) {

            Socket socket = new Socket("127.0.0.1", 2020);
            System.out.println("\nConexión " + i + " establecida con el servidor.");

            BufferedReader entradaSocket = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            PrintWriter salidaSocket = new PrintWriter(
                    new OutputStreamWriter(socket.getOutputStream()),
                    true
            );

            // Leer saludo del servidor
            String mensajeServidor = entradaSocket.readLine();
            System.out.println("Servidor dice: " + mensajeServidor);

            // Enviar respuesta al servidor
            System.out.print("Escribe tu nombre: ");
            String mensajeCliente = teclado.nextLine();
            salidaSocket.println(mensajeCliente);

            socket.close();
            System.out.println("Conexión " + i + " cerrada.");
        }

        // ASCII ART al final
        mostrarLuffy();
    }

    private void mostrarLuffy() {
        System.out.println("\n================= ASCII ART =================\n");
        System.out.println(
            "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxkkxxxxkO0kxxxOOOOOOOkkkkkkko'.'lxkkxdc:codxxxxxxxddddddl'      ..,:lodxdlcoxxxxxxdxxxxxxxxxxxxxxxxxkOO00kkkxddxxxkxxxxxkxkkxxxxkkxkkkkxxxxxxxxxxxxxxxxxxxxxxxx\n" +
            "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxkxxxxxkO000OOkOOOOOOOkkkkkxxxxo;..';:clc;'..',,,,'''''.....          ..',::;,,:ldxxxxxxxxxxxxxxxxxxxxkkOO00OOkxxdxxxkkxxkxxxxxxxxkxxkxkkxxxxxxxxxxxxxxxxxxxxxxxx\n" +
            "xxxxxxxxxxxxxxxxkkkkkkkkkkkkkkxxxxxxxxxkxxxxkO00000000OOOOOOkkkkkxxddxxd;.    ...                                 ... .':odxxxxxdddxxxxxxxxxxxkOO000Okkkxxxxkkxxxxkkkxxxkxxxkxxxxxxxxxxxxxxxxxxxxxxxxxx\n" +
            "xxxxxxxxxxxxxxxxxxxxxxxxxxxxkkxxkkxkkkxxxxkO0000000000OOOOOOkxdolc:;;;;;;:'                      .,.                      .,ldxdoooooodxxxxxxxxxkOO000OO00Oxxxxkxxxkkkkkkkxxxkxxxxxxxxxxxxkkkkkkkxxxxxxx\n" +
            "xxxxxxxxxxxxxxxxxxxxxxxkxxkkkkkkkkkkkkxxkO000000000000OOOdl;'..                                .:dd:'.                      .'cllcllodxxxxxxxxxxxkOO0000000Okxxxkkxkkkkkkkkkkkkkkkkkkxxxxxkkkkkkkxxxxxxx\n" +
            "xxxxxxxkkxxxxxxxxkkkxkkkkkkkkkkkkkkkxxxkO000000000000ko:'.                                    'lkOkdl:.   ..                  .,;,cdxxxxxxxxxxxxxxkOO00000000Oxdxkkkkkkkkkkkkkkkkkkkkkkkkxxkkkkkkxxxxxxx\n" +
            "xxxxxxxkkxxxxkkkkkkkkkkkkkkkkkkkkkkkxxk00000000000Od:.                                 .,.  .;dOOOOkxd;.  .;;.                    'oxxxxxxxxxxxxxxxkOO00000000Okxxkkkkkkkkkkkkkkkkkkkkkkkkkkkkxkxxxxxxxx\n" +
            "xxkkkxxxxxkkkkkkkkkkkOOOOOOOOOOOOOkkxk0000000000kl,...';:cccc,.                      .:l'  .cxO0OOOOOkd;   ,dc.   .'.              'ldxxxxxxxxxxxxxkkOOO0000000OOxxkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkxxxxxxx\n" +
            "kkxxxkkkkkkkkkkkOOOOO00000OOOO000OkxkO00000000kl,';cdxkkOko:.                .      .lx;  .lkO00OOOOOOko,  .dkc.   ,c'              .;odxxxxxxxxxxxxkkOOO00000000OkxkOOOOOOOOOOOOOOOkkkkkkkkkkkkkkkkkkkk\n" +
            "xxkkkkkkkkkOOOO00000KKK0OOOkkkkO00kk00000000Odc:okOOOkkdc'                 .,.     .lxl. .lk00OOOOOOOOOko. .lOx:.  .ll'               .':lddxxxxxxxxxkkOO000000000OkkOOOOOOOOOOOOOOOOOOOOkkkkkkkkkkkkkkk\n" +
            "kkkkkkkOOOO0000KKKKXK0kkO00OOkxdkOkO00000000kxkO0OOOkd:.                   ;:.    'okd' .lk000OOOOOOOOOOk:..ckxd;   :xo,                 ':loxxxxxdxxkkOOOO00000000OkkO000000000000000OOOOOOOkkkkkkkkkkk\n" +
            "kkkkkkkOO00KKKKXXXXXOoldkOOkdl::cdO00000000000000OOxc.                    ;d;    .lOOl..;xO0000000000000Od' ;xkkd,  ,xko'                .:oodooooodxxkkOOO000000000OkO000000KKKKK00000000OOOOOOkkkkkkkk\n" +
            "kOkxxkkOOO0KXXXXNNNXd:colcc,.   .oO0000000000000Oko'                     ;kd.   .:k0O; ,xOO00000000000000k;.:kOOkl. .okxl.                 'clllooodxxkkOOO0000000000Ok0KKKKKKKKKKKKKKK000000OOOOOOOkkkkk\n" +
            "OkooxkO00OO0XNNNNNNXx::;.       ,k0000000000000Ox;.                     ,x0l.   'd00O,.cOK000000000000000Ol.cOOOOk; .lkkd;                  .:loooodxxkkOOO00000000000OOKKKKKKKKKKKKKKKK000000OOOOOOOOkkk\n" +
            "kl:coxxkOkkkk0XNNNNXx;.  .','. .cO000000000000kl.                      .o0k, .:';k0KO,'d0K000000000000000Oo,oOOOOOo..lkkkl.   '.             .;oooddxxkkkOO00000000000OO0XXXXXXXXKKKKKKK00000OOOOOOOOOOk\n" +
            "d:;;:ldk0000Ok0NNNNXx;.  .',.. .d00000000000Oo,                       .cOOc..dk:l0KKO:;kK0000000000000000OocxOOOOOk,.oOkkd,  .l;              'cdxxxxxxkkOO000000000000O0XXXXXXXXXKKKKKKK00000OOOOOOOOOOO\n" +
            "l;;,;:dOXXX0OOOKXNNNK0o.   .   ,k000000000Od,.                        ,xOo.,x00xk0KK0ol0KK00000000000000OOdoOOOOOOk:,dkOOx:  ,xo.             .cdxxxxxxkkOO0000000000OOOOXXXXXXXXXKKKKKKK0000OOOOOOOOOOOO\n" +
            "o;;,;cxO0KXXKKKKKXNNNNXl.   .'.:O00OOOOkdc'       ..,:'              .cko;lO0kdllllooclO00K000000000000OOOkO0Okoc::'':::cl:. ckkc              'oxxxxxxkkOO0000000OkkkOOOKXXXXXXXXKKKKKKK0000OOOOOOOOOOOO\n" +
            "0l;,:ccloxKNNNXK0KXNNNW0;  .,,'lO00Oxoc;'.....,;cldxxc.              .lolxdc::clodxxdlc:oO0000000Ok000OOO00Oxc::lodllxxoc:. .dOOx,          .   ;dxxxxxkkOO00000000OkxkkOKXXXXXXXXKKKKKKK0000OOOOOOOOOOOO\n" +
            "Xk:;cc,.'cOKXNXKKKKXNWWNk.  ...cO000000OOkkkkOOOOkkx;.            .'..okd:;lxO0KKKKKK00xloO00K00OodO00OO00OdlokOOOOkkOOOOOc..:xkko.         .;. .lxxxxxkkOO000000000OxkkOKXXXXXXXXXKKKKK00000OOOOOOOOOOO\n" +
            "NKkolc,'':dO0XNNNNXKXWWWNo.    :O0000000000000OOkxl.              .c''dl'ck00KKKKKKKKKKK0OOKKK0k:,lOOOO000OkOOOOOOO0OOOOOOxdl,ckkkc.         :o,.:xxxxxkkOO000000000OkkkOKXXXXXXXXXKKKKKK00000000000000O\n" +
            "NXK0xlc:;:clod0NNNXXKXWWWK:   .:O0000000000000Oko,                .ol;:':OKKKKKKKKKKKKKKKKK0KKOl..oOOO0000000OOOOOOOOO0OOOOOkddkkkx:.        'oo:cxxxxxkkkO0000000000OOkOKXXXXXXXXXXKKKKKK0000000000000O\n" +
            "xxxxdl:::;''';xKXX000KXWMWO'  .,x000000000000kl'               .  .lkodxOKKKKKKKKKKKKKKK0000000OxdkO0000000OOOOOkkxxkkkxddkxddxxxxxxc.       .cxddxxxxxkkkO00000000000OkOXXXXXXXXXXXXKKKKKKKK000000000OO\n" +
            "ldxkdl::c;..':dk0KXXXXKKNMWd.  .lOOkOO0000xo;.    .,:'        .c:. ;k00KKKKKKKK000KKKKXXXXXNNNNNNNNNNNWNNNNNNNNXXXKK00OkxdkkkxxkOkkkkc.       ;dxxxxxxxkkkO00000000000Ok0XXXXXXXXXXXXKKKKKKKKKK0000000OO\n" +
            "ldkkxo;.';:::cldkOXNNXXKKNMXc   ;kOkxdol:'.  ..,:oxkl.         cOl..o0KKKKK00KKXXNNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWWNXK00OOOOOkkkkl.       ,dxxxxxxxkkkOO0000000000kOXXXXXXXXXXXXXKKKKKKKKKKK000000OO\n" +
            "cdkxc.   .:cc;,,:oOKXXXXKKXW0,  .dOxolc::clodxkOkkkd,          :00x;:kKK00KXNWMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMWNXK0Okkkkc        'oxxxxxxxkkkOO000000000OkKNNNXXXXXXXXXKKKKKKKKKKKKK000000O\n" +
            ",,;.      .;c;'.'cxO0XXXKOOKNx.  ;xkkk0KKK0000OOkkko.  .'.     ;OKKOdx0KXNWMMMMMMMMMMWWNNXXXKKK0000000000KKKXXXNWWMMMMMMMMMMWNKOkk;        'oxxxxxxxkkkOO000000000O0XNNNNNXXXXXXKKKKKKKKKKKKKKK00000O\n" +
            ".  ....    .;:;,;coxk0XXX000KKc  .cOO0KKKK0000OOOkkl.  :o'     'kKKK0KNWMMMMMMWXKOkxdolcc:::;;;;;;,,,,,,,,,,;;;:clodk0NWMMMMMMMXkx,     .. ;dxxxxxxxkkkOO00000000OOXNNNNNNNXXXXKKKKKKKKKKKKKKKKK00000\n" +
            "  .,;,.      ,cllc;;:lkXXXXXKKk,  'xKKKKKK00000OOkkl. 'dkc.    .dKKOONMMMMWXOdl:;,,,,,,,,,,,,,,,,,,,,,,,,,,''''.........':xXWMMMMMXOo.    .:,.cxxxxxxxxkkkOO00000000OKNWNNNNNNXXXXKKKKKKXXXXXXXXKKKKK000\n" +
            "  .','.       'cl:'..;d0KXKKXK0l.  :OKKKKKK0000OOOko..:kkx,    .lKKxo0WMMWXo;,,,,,;;;;;;,,,,,,,,,,,,,,,,,'''''............;kWMMMWXkxc.    'l:;loddxxxxxkkOOO0000000OKNWWWWNNNNXXXXXXKXXXXXXXXXXXXXKKKK00\n" +
            ";..     ....   .::,'';okOOOO0KXk,  .l0KKKKKK0000OOOx,.okkkd,    ;OKx::dkkko;,;;;;;;;;;;;;,,'..............................',codol;:d;    .ldllolllodxxxkkOO00000000KNWWWWWNNNNNXXXXXXXXXXXNNNXXXXXXKKK00\n" +
            "0ko;.  .,;,.    .;cccccldx0XXXXXk,  .d0KKKKKK000OOOkl;dkkkkd;.. 'xKkc,,,,;;;;;;;;;;;;;;;,.                 .....................'lo'   .lxdooodooooxxkkkOO00000000NWWWWWWNNNNNXXXXXXXXXNNNNNNXXXXXKKK00\n" +
            "0000ko:,'''.     .;cl:''';o0XXXXXO;  ,kKKKKKKK000OOOxoxkkkxkOOkxoxK0l,,,;;;;;;;;;;;;;;;,.                    ....................:xoc:::oddxxdoodxdxxxkkOOO000000KNWWWWWWWNNNNXXXXXXXXXNNNNNNNNXXXXKK000\n" +
            "00000K0ko;.        ,c;'..,oO0XXK0KOc..:k0KKKK00000OOOkkkkkxOOxxOOkOKd;,,;;;;;;;;;;;;;;;,.                    ...................,dxollodkxddxxxdxxxxxxkkOO000000KNWWWWWWNNNNNXXXXXXXXXNNNNNNNNNXXXKKK00O\n" +
            "00000K0KK0xc,'..    ';,,,;lkO0KK00KKo. ;k0KKKK00000OOOkkkxk0OOOxxkkO0c,,,;;;;;;;;;;;;;;,.                    ..................'lxolldkOOkxdxxxxxxxxxkkkO0000O0KNWWWWWWWNNNNNXXXXXXXXNNNNNNNNNXXXKK000Ok\n" +
            "0000K0KKKKK0Od:.     .:ccc;;cld0XNXNXx' 'd0K0K000000OOOkkxk00OkxodkO0d;,,,;;;;;;;;;;;;;;,',;;:::::::::::;;;,,,,'...............:xdlodk0KKOddxxxxxxxxxkkOO000O0XWWWWWWWWNNNNNNXXXXXXXNNNNNNNNNXXXKK00Okkk\n" +
            "0000KKKKKKKKKK0x;.    .;::'.'';xKXNNNXO; .lO000000000OOOkxO0kxkkdxkkO0o;,,;;;;;;;;;;:lodxkkkkkxxxddoooooolllllcc;,...........:ddloxkk0K0kdxxxxddxxxxkkO00O0KNWWWWWWWWNNNNNNXXXXXXXNNNNNNNXXXXKKK0OkOO0K\n" +
            "0000KKKKKKKKKKKK0xl,.  .;;'...:k0KXNXXXO:..;d000000000OOOkk00OO0xx0Ok0Ol;,,;;;;;;;cdkO0OOOOOOOkkxxddddooooooolllll:'........:ddlodxkO0KkddxxdooodxxxkOOO0KNWWWWNNNNNNNNNNNNXXXXXXNNNNNXXXXXKK0OOOO0KKKK\n" +
            "000000KKKKKKKKKKKKKOo'  .,;;;;cdO0KXK0O00o. .;dO0000OkkkOkkOKOO0xxO0Ok00o;,;clc;:oO00000OOOOOOOkkkxxxxddddoooooollllc;:ll:,':ddloxkkO0KOxdxxxdooddxxkkk0KNNNNNNNNNNNNNNNNXXXXXXXXXNNXXXXXXKK0OO00KKKKKKK\n" +
            "000000KKK0KKKKKKKKKK0Ol' .,cllc;:loxKXXKXXd.  .:dkkkkxkkOOkkO00OkO0K0kxO0xoONNXxdO000OOOOOOOOkkkkkkkkxxxxddddooooollllkWMNkodooxkkO0KKOdddddddodxxxxk0KNNNNNNNNNNNNNNNNXXXXXXXXXXXXXXXXK00OO00KKKKKKKKKK\n" +
            "00000KKK0000KKKKKKKKKKKOd;.,cc;'.'';xXNNXXXk,  .';lxxxxxkOOOkkO00O0OO0Okk0KKNWXOO0OOOOOOOOOkkkkkkkkkxxxxxxxxxdddoooolldKNKkdoxO0O00K0kdoooooodxxxkO0XNNNNNNNNNNNNNNNNXXXXXXXXXXXXXXXK0OOO00KKKKKKKKKKKKK\n" +
            "000000KK00000KKKKKKKKKKKK0xllc;,,''ck0KXXXXXO:......;lxxkkOOOOkkOOOO0KKK0kO0KKK0K00OOOOOOkkkkkxxxxxxxxxxxxxxxxxxxxkkO0KKOxodk0000OOkxdddodddxkO0KNNNNNNNXXXXXXXXXXXXXXXXXXXXXXXKK000O00KKKKKKKKKKKKKKKKK\n" +
            "0000000000000KKKKKKKKKKKKKK0OxolccclxO00XXXKK0l.    ..,:ldxkOO0OOOkkOOOOOOkxO0KKXXXNNXXXXXXXKKKKKKKKKXXXXXXNNNNWWWNKOxxdddxkkxxxddxxddxkO0KXNWWNNNNNXXXXXXXXXXXXXXXXXXXKK00OOOOO00KKKKKKKKKKKKKKKKK000\n" +
            "000000000000000KKKKKKKKKKKKKK0Okdolccd000KXXXXKd.  .',''..';ldkOOOOOOOOOOOOOOOO00KKXNWMMMMMMMMMMMMMMMMMMMMMMMMMMWNK0kxxxxxxxdxxxddxxkO0KXNWWWWWNNNNXXXXXXXXXXXXXXXXXK00OOOkkkOO000KKKKKKKKKKKKKKKKK00000\n" +
            "0000000000KKKK0KKKKKKKKKKKKKKK00OOkxddxOOkkxxxk0x' ...,;;,.. .;looxxkOOOOOOOOOOOOOO00KXXNWMMMMMMMMMMMMMMMMMMWNXK0kdddxxxxxddxxkO0KKXNWWWWWWWNNNNNXXXXKKKKKKKXXK00OOkkkkkkOOOO000KKKKKKKKKKKKKKKKK0000000\n" +
            "00000000000KK00KKKKKKKKKKKKKKKKK00Okkkkkxdl::::coc'.',;:::::;;:::;::cloodxxkOO000kdoxkO0KKKXXNNWWWMMMMWWNXXK0OxxdolldxxkkO0KXNNWWWWWWWWWWNNNNNNXXXXKKKKKKK00OOkkkkkkOOOOOOO000KKKKKKKKKKKKKKKKKK00000000\n" +
            "000000000000000KKKKKKKKKKKKKKKKKKK0Okkkkkkkxoc:::;,;;,,;;;;;:::::::::::::::o0KKK0OxxxdddxkO0000KKKKKKK00OOkxdooloold0KXNWWWWWWWWWWWNNNNNNNNNXXXKKKKKK00OkkkkkkkkOOOOOOO0000KKKKKKKKKKKKKKKKKKK00000000\n" +
            "0000000000000000KKKKKKKKKKKKKKKKKKK00Okkkkkkkxl:::;;;;;,,;;;;;;:::cccc:::::dXMWWWNK0K0OkxddddxxxkkkxxxxxdoollooooooONWWWWWWWWWWNNNNNNNNNNNNNXXXK0kxdoodxkkkkkkkkkkOOOOOO000KKKKKKKKKKKKK0000000000000000\n" +
            "0000000000000000000KKKKKKKKKKKKKKKKKK0Okkkkkkkxl:::::;;;;,,,;::;,;,,;:cc:::l0NWWWWWXKXXXKK0OkxdoolllllllloooooooooloOWWWWWWWNNNNNNNNNNNNNNNXKOxoc:,,'',:dkkkkkkkkkOOOOO000KKKKKKKKKKKKKKKKK0000000000000\n" +
            "0000000000000000000KKKKKKKKKKKKKKKKKKK0Okkkkkkkdc:::::;;;;;,cdxdc.  .;::lkKWWWWWWWXKXXXXXXKKK0Okxddooooooooooooooo0WWWWNNNNNNXXXXXXXXXKOxo:;''''',,,:dkkkkkkkkkOOOO000KKKKKKKKKKKKKKKKK00000000000000\n" +
            "00000000000000000000KKKKKKKKKKKKKKKKKKK0Okkkkkkko::::::;;;;,;l0XKd.   ,xKNWWWWWWWWXKXXXXXXXKKKKKK0OOkxddooooooooold0NNNNNNNXXXXXXXXK0xo:,'''''''',,,:dkkkkkkkkOOOOO00KKKKKKKKKKKKKKKKK000000000000000O\n" +
            "00000000000000000000000KKKKKKKKKKKKKKKKK0Okkkkkkdc:::::;;;;,,;l0XKdcc,.;ONNWNWWWWWK0KKXXXXKKXXKKKKKKKK0Okxdoooooold0NNNNXXXXXKKKKOdl;'''''''',,',,';okkkkkkkkOOOO000KKKKKKKKKKKKKKKKK0000000000000000OOO\n" +
            "kOO00000000000000000000KKKKKKKKKKKKKKKKK0Okkkkkkxc::::::;;;;,,;lOXKO0Kx:ckKNXXXXNNK0KKKKKKKKKKKKKKKKKKKK0Okxdooold0XXXXK00KK0kdl;''''',,,,,,,,,,,,lkOOkkkkkOOO000KKKKKKKKKKKKKKK0000000000000000000OOOO\n" +
            "0OkOO000000000000000000KKKKKKKKKKKKKKKKK00Okkkkkxl::::::;;;;;,,;lOX0OKX0O00O0KK00K00KKKKKKKKKKKKKKKKKKKKKK00Oxdod0XKkoc:cllc:,,,,,,,,;;;;;;;;;;;ckOOOOOOOOOO00KKKKKKKKKKKKKK000000000000000000OOOOO\n" +
            "000OOOO00000000000000000KKKKKKKKKKKKKKKK00Okkkkkxl::::::;;;;,,,,,l0K0OKX00K00XXK0kO00KKKKKKKKKKKKKKKKKKKKKKKKK0Oxxxl:;;:::;;;;;;;;;;;:::::::::;:d0000OOOOO000KKKKKKKKKKKKK00000000000000000OOOOOOOO\n" +
            "000000OOO0000000000000000000KKKKKKKKKKKK00OOkkkkxl;:::::;;;;,,,,,,o0K00KKO0K00K0OO000000KKKKKKKKKKKKKKKKKKKKKKK0o:;;;:::::::::::::::::::;;;;;;lk00000OOO000KKKKKKKKKKK0000000000000000000OOOOOOOkk\n" +
            "O0000KK0OkO00000000000000000000KKKKKKKKK000Okkkkxl;:::::;;;;,,,,,':kXKO00OO00OOkO000000000000KKKKKKKKKKKKKKKKKKKKkl;;:::::::::::::::;;;;;;;;;;oO0OOOOOOO000KKKKKKKKK00000000000000000000OOOOOOkxxx"
        );
        System.out.println("\n============================================");
    }

    public static void main(String[] args) {
        try {
            new Cliente();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
