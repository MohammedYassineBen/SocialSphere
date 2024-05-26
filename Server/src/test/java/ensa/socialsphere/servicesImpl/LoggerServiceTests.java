package ensa.socialsphere.servicesImpl;

import ensa.socialsphere.domain.entities.*;
import ensa.socialsphere.domain.models.serviceModels.LoggerServiceModel;
import ensa.socialsphere.repositories.LoggerRepository;
import ensa.socialsphere.services.LoggerService;
import ensa.socialsphere.utils.responseHandler.exceptions.CustomException;
import ensa.socialsphere.validations.serviceValidation.services.LoggerValidationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import ensa.socialsphere.testUtils.*;

import java.util.*;

import static junit.framework.TestCase.assertTrue;
import static ensa.socialsphere.utils.constants.ResponseMessageConstants.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerServiceTests {

    @Autowired
    private LoggerService loggerService;

    @MockBean
    private LoggerRepository mocensaoggerRepository;

    @MockBean
    private LoggerValidationService mocensaoggerValidation;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUpTest() {

    }

    @Test
    public void createLog_whenInputsAreValid_createLog(){
        // Arrange
        Logger log = LoggerUtils.createLog();

        when(mocensaoggerValidation.isValid(anyString(), anyString(), anyString(), anyString()))
                .thenReturn(true);

        when(mocensaoggerValidation.isValid(any(LoggerServiceModel.class)))
                .thenReturn(true);


        when(mocensaoggerRepository.save(any()))
                .thenReturn(log);

        // Act
        boolean result = loggerService.createLog(log.getMethod(), log.getUsername(), log.getTableName(), log.getAction());

        // Assert
        assertTrue(result);

        verify(mocensaoggerRepository).save(any());
        verify(mocensaoggerRepository, times(1)).save(any());
        verifyNoMoreInteractions(mocensaoggerRepository);
    }

    @Test()
    public void createComment_whenInputsAreNotValid_throwException(){
        // Arrange
        Logger log = LoggerUtils.createLog();

        when(mocensaoggerValidation.isValid(anyString(), anyString(), anyString(), anyString()))
                .thenReturn(false);

        when(mocensaoggerValidation.isValid(any(LoggerServiceModel.class)))
                .thenReturn(true);

        when(mocensaoggerRepository.save(any()))
                .thenReturn(log);

        thrown.expect(CustomException.class);
        thrown.expectMessage(FAILURE_LOGS_SAVING_MESSAGE);
        // Act
       loggerService.createLog(log.getMethod(), log.getUsername(), log.getTableName(), log.getAction());
    }


    @Test()
    public void createComment_whenLoggerServiceModelIsNotValid_throwException(){
        // Arrange
        Logger log = LoggerUtils.createLog();

        when(mocensaoggerValidation.isValid(anyString(), anyString(), anyString(), anyString()))
                .thenReturn(true);

        when(mocensaoggerValidation.isValid(any(LoggerServiceModel.class)))
                .thenReturn(false);

        when(mocensaoggerRepository.save(any()))
                .thenReturn(log);

        thrown.expect(CustomException.class);
        thrown.expectMessage(FAILURE_LOGS_SAVING_MESSAGE);
        // Act
        loggerService.createLog(log.getMethod(), log.getUsername(), log.getTableName(), log.getAction());
    }

    @Test()
    public void createComment_whenLoggerRepositoryDontSaveLog_throwException(){
        // Arrange
        Logger log = LoggerUtils.createLog();

        when(mocensaoggerValidation.isValid(anyString(), anyString(), anyString(), anyString()))
                .thenReturn(true);

        when(mocensaoggerValidation.isValid(any(LoggerServiceModel.class)))
                .thenReturn(true);

        when(mocensaoggerRepository.save(any()))
                .thenReturn(null);

        thrown.expect(CustomException.class);
        thrown.expectMessage(FAILURE_LOGS_SAVING_MESSAGE);
        // Act
        loggerService.createLog(log.getMethod(), log.getUsername(), log.getTableName(), log.getAction());

        verify(mocensaoggerRepository).save(any());
        verify(mocensaoggerRepository, times(1)).save(any());
        verifyNoMoreInteractions(mocensaoggerRepository);
    }

    @Test
    public void getAllLogs_when2Logs_2Logs() {
        // Arrange
        List<Logger> logs = LoggerUtils.getLogs(2);

        when(mocensaoggerRepository.findAllByOrderByTimeDesc()).thenReturn(logs);

        // Act
        List<LoggerServiceModel> allLogs = loggerService.getAllLogs();

        // Assert
        Logger expected = logs.get(0);
        LoggerServiceModel actual = allLogs.get(0);

        assertEquals(2, allLogs.size());
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getUsername(), actual.getUsername());
        assertEquals(expected.getAction(), actual.getAction());
        assertEquals(expected.getMethod(), actual.getMethod());
        assertEquals(expected.getTableName(), actual.getTableName());
        assertEquals(expected.getTime(), actual.getTime());

        verify(mocensaoggerRepository).findAllByOrderByTimeDesc();
        verify(mocensaoggerRepository,times(1)).findAllByOrderByTimeDesc();
        verifyNoMoreInteractions(mocensaoggerRepository);
    }

    @Test
    public void getAllLogs_whenNoLogs_returnEmptyPosts() {
        when(mocensaoggerRepository.findAllByOrderByTimeDesc()).thenReturn(new ArrayList<>());

        List<LoggerServiceModel> allLogs = loggerService.getAllLogs();

        Assert.assertTrue(allLogs.isEmpty());

        verify(mocensaoggerRepository).findAllByOrderByTimeDesc();
        verify(mocensaoggerRepository,times(1)).findAllByOrderByTimeDesc();
        verifyNoMoreInteractions(mocensaoggerRepository);
    }

    @Test
    public void getLogsByUsername_when2Logs_2Logs() {
        // Arrange
        List<Logger> logs = LoggerUtils.getLogs(2);

        when(mocensaoggerValidation.isValid(anyString())).thenReturn(true);

        when(mocensaoggerRepository.findAllByUsernameOrderByTimeDesc(anyString())).thenReturn(logs);

        // Act
        List<LoggerServiceModel> allLogs = loggerService.getLogsByUsername("pesho");

        // Assert
        Logger expected = logs.get(0);
        LoggerServiceModel actual = allLogs.get(0);

        assertEquals(2, allLogs.size());
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getUsername(), actual.getUsername());
        assertEquals(expected.getAction(), actual.getAction());
        assertEquals(expected.getMethod(), actual.getMethod());
        assertEquals(expected.getTableName(), actual.getTableName());
        assertEquals(expected.getTime(), actual.getTime());

        verify(mocensaoggerRepository).findAllByUsernameOrderByTimeDesc(anyString());
        verify(mocensaoggerRepository,times(1)).findAllByUsernameOrderByTimeDesc(anyString());
        verifyNoMoreInteractions(mocensaoggerRepository);
    }

    @Test
    public void getLogsByUsername_whenUsernameIsNotValid_throwException() {
        // Arrange
        List<Logger> logs = LoggerUtils.getLogs(2);

        when(mocensaoggerValidation.isValid(anyString())).thenReturn(false);

        when(mocensaoggerRepository.findAllByUsernameOrderByTimeDesc(anyString())).thenReturn(logs);

        thrown.expect(CustomException.class);
        thrown.expectMessage(SERVER_ERROR_MESSAGE);

        // Act
        loggerService.getLogsByUsername("pesho");

    }

    @Test
    public void getLogsByUsername_whenNoLogs_throwException() {
        // Arrange
        when(mocensaoggerValidation.isValid(anyString())).thenReturn(true);

        when(mocensaoggerRepository.findAllByUsernameOrderByTimeDesc(anyString())).thenReturn(new ArrayList<>());

        thrown.expect(CustomException.class);
        thrown.expectMessage(FAILURE_LOGS_NOT_FOUND_MESSAGE);

        // Act
        loggerService.getLogsByUsername("pesho");

        // Assert
        verify(mocensaoggerRepository).findAllByUsernameOrderByTimeDesc(anyString());
        verify(mocensaoggerRepository,times(1)).findAllByUsernameOrderByTimeDesc(anyString());
        verifyNoMoreInteractions(mocensaoggerRepository);
    }

    @Test
    public void deleteAll_whenInputIsValid_deleteAll() throws Exception {
        // Act
        boolean result = loggerService.deleteAll();

        // Assert
        assertTrue(result);

        verify(mocensaoggerRepository).deleteAll();
        verify(mocensaoggerRepository,times(1)).deleteAll();
        verifyNoMoreInteractions(mocensaoggerRepository);
    }

    @Test
    public void deleteByName_whenUsernameIsValidAndUserHasAnyNumberLogs_returnTrue() {
        // Arrange
        List<Logger> logs = LoggerUtils.getLogs(2);

        when(mocensaoggerValidation.isValid(anyString())).thenReturn(true);

        when(mocensaoggerRepository.deleteAllByUsername(anyString())).thenReturn(logs);

        // Act
        boolean result = loggerService.deleteByName("pesho");

        // Assert
        assertTrue(result);

        verify(mocensaoggerRepository).deleteAllByUsername(anyString());
        verify(mocensaoggerRepository,times(1)).deleteAllByUsername(anyString());
        verifyNoMoreInteractions(mocensaoggerRepository);
    }

    @Test
    public void deleteByName_whenUsernameIsNotValid_throwException() {
        // Arrange
        List<Logger> logs = LoggerUtils.getLogs(2);

        when(mocensaoggerValidation.isValid(anyString())).thenReturn(false);

        when(mocensaoggerRepository.deleteAllByUsername(anyString())).thenReturn(logs);

        thrown.expect(CustomException.class);
        thrown.expectMessage(SERVER_ERROR_MESSAGE);

        // Act
        loggerService.deleteByName("pesho");
    }

    @Test
    public void deleteByName_whenUsernameIsValidAndUserHasNoLogs_throwException() {
        // Arrange
        when(mocensaoggerValidation.isValid(anyString())).thenReturn(true);

        when(mocensaoggerRepository.deleteAllByUsername(anyString())).thenReturn(new ArrayList<>());

        thrown.expect(CustomException.class);
        thrown.expectMessage(FAILURE_LOGS_NOT_FOUND_MESSAGE);

        // Act
        loggerService.deleteByName("pesho");
    }
}
