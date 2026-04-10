package semester6;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;

public class UserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");

        try {
            // XML file path
            String filePath = getServletContext().getRealPath("/users.xml");
            File xmlFile = new File(filePath);

            // Document Builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc;

            if (xmlFile.exists() && xmlFile.length() > 0) {
                doc = builder.parse(xmlFile);
            } else {
                doc = builder.newDocument();
                Element root = doc.createElement("users");
                doc.appendChild(root);
            }

            // Root element
            Element root = doc.getDocumentElement();

            // Create new user element
            Element user = doc.createElement("user");

            Element emailElement = doc.createElement("email");
            emailElement.appendChild(doc.createTextNode(email));

            user.appendChild(emailElement);
            root.appendChild(user);

            // Write to XML file
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(xmlFile);

            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Display values
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>User Details</h2>");
        out.println("Username: " + username + "<br>");
        out.println("Email: " + email + "<br>");
    }
}