package ru.kpfu.itis.listeners;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.entities.CategoryEntity;
import ru.kpfu.itis.entities.CoachEntity;
import ru.kpfu.itis.entities.SpecialityEntity;
import ru.kpfu.itis.services.impls.ServiceManager;
import ru.kpfu.itis.constants.Constants;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Map;


@WebListener
public class ApplicationListener implements ServletContextListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationListener.class);
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServiceManager serviceManager = ServiceManager.getInstance(sce.getServletContext());
        Map<Integer, CategoryEntity> mapCategories = serviceManager.getBusinessService().mapCategories();
        sce.getServletContext().setAttribute(Constants.CATEGORY_MAP, mapCategories);
        Map<Integer, CoachEntity> mapCoaches = serviceManager.getBusinessService().mapCoaches();
        sce.getServletContext().setAttribute(Constants.COACH_MAP, mapCoaches);
        Map<Integer, SpecialityEntity> mapSpeciality = serviceManager.getBusinessService().mapSpeciality();
        sce.getServletContext().setAttribute(Constants.SPECIALITY_MAP, mapSpeciality);
        ServiceManager.getInstance(sce.getServletContext());
        LOGGER.info("Application started");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServiceManager.getInstance(sce.getServletContext()).destroy();
        LOGGER.info("Application destroyed");
    }
}

