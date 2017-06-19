package com.swayam.kotlintestapp.ui.activity

class XmlParserActivity : android.support.v7.app.AppCompatActivity() {

    var tvXmlParser : android.widget.TextView? = null

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.swayam.kotlintestapp.R.layout.activity_xml_parser)

        val file = assets.open("file1")

        tvXmlParser = findViewById(com.swayam.kotlintestapp.R.id.tvXmlParser) as android.widget.TextView

        var docBuildFac = javax.xml.parsers.DocumentBuilderFactory.newInstance()
        var docBuild = docBuildFac.newDocumentBuilder()
        var doc = docBuild.parse(file)

        var nodeList = doc.getElementsByTagName("city")

        for (i in 0..nodeList.length-1) {

            var node = nodeList.item(i)

            if (node.nodeType == org.w3c.dom.Node.ELEMENT_NODE){

                var element = node as org.w3c.dom.Element

                var id = element.getAttribute("id")
                printData(id)
                var name = element.getAttribute("name")
                printData(name)

                var coord = element.getElementsByTagName("coord").item(0) as org.w3c.dom.Element
                var lon = coord.getAttribute("lon")
                printData(lon)
                var lat = coord.getAttribute("lat")
                printData(lat)

                var country = element.getElementsByTagName("country").item(0).childNodes.item(0).nodeValue
                printData(country)

                var sun = element.getElementsByTagName("sun").item(0) as org.w3c.dom.Element
                var rise = sun.getAttribute("rise")
                printData(rise)
                var set = sun.getAttribute("set")
                printData(set)

            }
        }

        var nList = doc.getElementsByTagName("temperature")

        for (i in 0..nList.length-1) {

            var node = nList.item(i)

            if (node.nodeType == org.w3c.dom.Node.ELEMENT_NODE) {

                var temperature = node as org.w3c.dom.Element

                var value = temperature.getAttribute("value")
                printData(value)
                var min = temperature.getAttribute("min")
                printData(min)
                var max = temperature.getAttribute("max")
                printData(max)
                var unit = temperature.getAttribute("unit")
                printData(unit)

            }
        }

        var nodList = doc.getElementsByTagName("rajesh")

        for (i in 0..nodList.length-1) {

            var node = nodList.item(i)

            if (node.nodeType == org.w3c.dom.Node.ELEMENT_NODE) {

                var humidity = node as org.w3c.dom.Element

                var value = humidity.getAttribute("value")
                printData(value)
                var unit = humidity.getAttribute("unit")
                printData(unit)
            }
        }

        var nodesList = doc.getElementsByTagName("pressure")

        for (i in 0..nodesList.length-1) {

            var node = nodesList.item(i)

            if (node.nodeType == org.w3c.dom.Node.ELEMENT_NODE) {

                var pressure = node as org.w3c.dom.Element

                var value = pressure.getAttribute("value")
                printData(value)
                var unit = pressure.getAttribute("unit")
                printData(unit)
            }
        }
    }

    fun printData(data : String){

        tvXmlParser?.text = tvXmlParser?.text.toString() + "\n" + data
    }
}
