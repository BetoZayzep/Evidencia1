import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener parámetros del formulario
        String nombreCompleto = request.getParameter("nombreCompleto");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String sexo = request.getParameter("sexo");
        double estatura = Double.parseDouble(request.getParameter("estatura"));
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");

        // Validar estatura y edad
        if (estatura > 2.5 || estatura < 1 || edad < 15) {
            response.sendRedirect("registro.html");
            return;
        }

        // Crear una nueva sesión o obtener la sesión existente
        HttpSession session = request.getSession(true);

        // Calcular el IMC y guardarlo en la sesión
        double peso = Double.parseDouble(request.getParameter("peso"));
        double imc = peso / (estatura * estatura);
        session.setAttribute("imcActual", imc);

        // Obtener el historial de cálculos de IMC desde la sesión
        List<IMCData> historialIMC = (List<IMCData>) session.getAttribute("historialIMC");
        if (historialIMC == null) {
            historialIMC = new ArrayList<>();
        }

        // Agregar el nuevo cálculo de IMC al historial
        historialIMC.add(new IMCData(imc, LocalDate.now()));

        // Guardar el historial en la sesión
        session.setAttribute("historialIMC", historialIMC);

        // Redireccionar a la página de la calculadora
        response.sendRedirect("calculadora.jsp");
    }
}
