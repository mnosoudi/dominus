import static org.junit.Assert.*;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import com.dominus.dominus.Authorizer;
import com.dominus.dominus.SignupValidate;

//import org.mockito.Mockito;
import junit.framework.TestCase;
/*import org.powermock.api.easymock.PowerMock;
import org.powermock.api.easymock.annotation.Mock;
import org.powermock.api.mockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when; 
import org.mockito.Matchers;
import static org.mockito.Matchers.*;*/

//@RunWith(PowerMockRunner.class)
//@PrepareForTest({Authorizer.class})

public class SignUpViewTest extends TestCase {
		
	//This test addresses the length of the first name (over 20 characters)
	@Test(expected = NullPointerException.class)
	public void testFirstNameLengthOver() throws NoSuchAlgorithmException 
	{
		SignupValidate signupValidate = new SignupValidate();
		signupValidate.testLength("123456789012345678901");		
	}
		
	//This test addresses the length of the last name (equal to 20 characters)
	@Test
	public void testFirstNameNameLengthUnder() throws NoSuchAlgorithmException 
	{
		SignupValidate signupValidate = new SignupValidate();
		signupValidate.testLength("12345678901234567890");		
	}  
	  
	//This test addresses if the first name is empty
	@Test(expected = NullPointerException.class)
	public void testFirstNameLengthEmpty() throws NoSuchAlgorithmException 
	{
		SignupValidate signupValidate = new SignupValidate();
		signupValidate.testLength("");		
	}
		
	//This test addresses if the first name is null
	@Test(expected = NullPointerException.class)
	public void testFirstNameLengthNull() throws NoSuchAlgorithmException 
	{
		SignupValidate signupValidate = new SignupValidate();
		signupValidate.testLength(null);		
	}
	  
	//This test addresses if the first name contains numbers
	@Test(expected = NullPointerException.class)
	public void testFirstNameNumbers() throws NoSuchAlgorithmException 
	{
		SignupValidate signupValidate = new SignupValidate();
		signupValidate.testLetters("123456");		
	}
		
	//This test addresses if the last name contains letters
	@Test
	public void testFirstNameLetters() throws NoSuchAlgorithmException 
	{
		SignupValidate signupValidate = new SignupValidate();
		signupValidate.testLetters("ALEXISTHEBEST");		
	}
  
	//This test checks for an email address with only one '@' character
	@Test
	public void testEmailOneAt() 
	{
		SignupValidate signupValidate = new SignupValidate();
		assertTrue(signupValidate.testAt("test@test.com"));
	}
	
	//This test detects an email address with zero '@' characters
	@Test
	public void testEmailNoAt()
	{
		SignupValidate signupValidate = new SignupValidate();
		assertFalse(signupValidate.testAt("testtest.com"));
	}
	
	//This test detects an email address with more than one '@' character
	@Test
	public void testEmailGreaterThanOneAt()
	{
		SignupValidate signupValidate = new SignupValidate();
		assertFalse(signupValidate.testAt("test@@test.com"));
	}
		
	//This test ensures the email address has at least one '.' character
	@Test
	public void testEmailOnePeriod()
	{
		SignupValidate signupValidate = new SignupValidate();
		assertTrue(signupValidate.testPeriod("test@test.com"));
	}
	
	//This test detects an email address with no '.' characters
	@Test
	public void testEmailNoPeriod()
	{
		SignupValidate signupValidate = new SignupValidate();
		assertFalse(signupValidate.testPeriod("test@testcom"));
	}
  
    //This test checks for null Password
	@Test
    public final void whenPasswordIsNullExceptionIsThrown() {
		SignupValidate signupValidate = new SignupValidate();
    	assertNull(signupValidate.passwordNull(null));
    }
    
    //This test checks for an empty Password
	@Test
    public final void whenPasswordIsEmptyExceptionIsThrown() {
		SignupValidate signupValidate = new SignupValidate();
    	assertFalse(signupValidate.passwordEmpty(""));
    }
    
	//This test checks the less than size of the password
	@Test
    public final void whenLessThan6CharactersThenExceptionIsThrown() {
		SignupValidate signupValidate = new SignupValidate();
        AssertFalse(signupValidate.password("123AB"));
    }
    
    //This test checks the more than size of the password
	@Test(expected = RuntimeException.class)
    public final void whenMoreThan20CharactersThenExceptionIsThrown() {
		SignupValidate signupValidate = new SignupValidate();
        assertFalse(signupValidate.password("0123456789ABCDEFGHIJK"));
    }
    
    //This test checks the acceptable size of the password
    @Test
    public final void when6AndMoreCharactersThenNoExceptionIsThrown() {
    	SignupValidate signupValidate = new SignupValidate();
    	assertTrue(signupValidate.password("123ABC"));
    }
    
}