using System;
using System.Collections;
using System.IO;

public class MyClass {
    public static void Main() {
        String fs[] = Directory.GetFiles(@"~/");
        bool foundXML = false;
        int i = 0;
        for (i=0; i < fs.Length; i++) {
            if(String.Compare(Path.GetExtension(fs[i]), ".xml", true)))
        }
    }
}