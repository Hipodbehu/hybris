/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Feb 10, 2022, 3:05:30 PM                    ---
 * ----------------------------------------------------------------
 */
package com.myapp.questions.jalo;

import com.myapp.questions.constants.QuestionsConstants;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.product.Product;
import de.hybris.platform.jalo.type.CollectionType;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.user.Customer;
import de.hybris.platform.util.BidirectionalOneToManyHandler;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem Question}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedQuestion extends GenericItem
{
	/** Qualifier of the <code>Question.code</code> attribute **/
	public static final String CODE = "code";
	/** Qualifier of the <code>Question.question</code> attribute **/
	public static final String QUESTION = "question";
	/** Qualifier of the <code>Question.questionCustomer</code> attribute **/
	public static final String QUESTIONCUSTOMER = "questionCustomer";
	/** Qualifier of the <code>Question.answer</code> attribute **/
	public static final String ANSWER = "answer";
	/** Qualifier of the <code>Question.answerCustomer</code> attribute **/
	public static final String ANSWERCUSTOMER = "answerCustomer";
	/** Qualifier of the <code>Question.product</code> attribute **/
	public static final String PRODUCT = "product";
	/**
	* {@link BidirectionalOneToManyHandler} for handling 1:n PRODUCT's relation attributes from 'one' side.
	**/
	protected static final BidirectionalOneToManyHandler<GeneratedQuestion> PRODUCTHANDLER = new BidirectionalOneToManyHandler<GeneratedQuestion>(
	QuestionsConstants.TC.QUESTION,
	false,
	"product",
	null,
	false,
	true,
	CollectionType.SET
	);
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(CODE, AttributeMode.INITIAL);
		tmp.put(QUESTION, AttributeMode.INITIAL);
		tmp.put(QUESTIONCUSTOMER, AttributeMode.INITIAL);
		tmp.put(ANSWER, AttributeMode.INITIAL);
		tmp.put(ANSWERCUSTOMER, AttributeMode.INITIAL);
		tmp.put(PRODUCT, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Question.answer</code> attribute.
	 * @return the answer
	 */
	public String getAnswer(final SessionContext ctx)
	{
		return (String)getProperty( ctx, ANSWER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Question.answer</code> attribute.
	 * @return the answer
	 */
	public String getAnswer()
	{
		return getAnswer( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Question.answer</code> attribute. 
	 * @param value the answer
	 */
	public void setAnswer(final SessionContext ctx, final String value)
	{
		setProperty(ctx, ANSWER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Question.answer</code> attribute. 
	 * @param value the answer
	 */
	public void setAnswer(final String value)
	{
		setAnswer( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Question.answerCustomer</code> attribute.
	 * @return the answerCustomer
	 */
	public Customer getAnswerCustomer(final SessionContext ctx)
	{
		return (Customer)getProperty( ctx, ANSWERCUSTOMER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Question.answerCustomer</code> attribute.
	 * @return the answerCustomer
	 */
	public Customer getAnswerCustomer()
	{
		return getAnswerCustomer( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Question.answerCustomer</code> attribute. 
	 * @param value the answerCustomer
	 */
	public void setAnswerCustomer(final SessionContext ctx, final Customer value)
	{
		setProperty(ctx, ANSWERCUSTOMER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Question.answerCustomer</code> attribute. 
	 * @param value the answerCustomer
	 */
	public void setAnswerCustomer(final Customer value)
	{
		setAnswerCustomer( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Question.code</code> attribute.
	 * @return the code - Code for question
	 */
	public String getCode(final SessionContext ctx)
	{
		return (String)getProperty( ctx, CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Question.code</code> attribute.
	 * @return the code - Code for question
	 */
	public String getCode()
	{
		return getCode( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Question.code</code> attribute. 
	 * @param value the code - Code for question
	 */
	public void setCode(final SessionContext ctx, final String value)
	{
		setProperty(ctx, CODE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Question.code</code> attribute. 
	 * @param value the code - Code for question
	 */
	public void setCode(final String value)
	{
		setCode( getSession().getSessionContext(), value );
	}
	
	@Override
	protected Item createItem(final SessionContext ctx, final ComposedType type, final ItemAttributeMap allAttributes) throws JaloBusinessException
	{
		PRODUCTHANDLER.newInstance(ctx, allAttributes);
		return super.createItem( ctx, type, allAttributes );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Question.product</code> attribute.
	 * @return the product
	 */
	public Product getProduct(final SessionContext ctx)
	{
		return (Product)getProperty( ctx, PRODUCT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Question.product</code> attribute.
	 * @return the product
	 */
	public Product getProduct()
	{
		return getProduct( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Question.product</code> attribute. 
	 * @param value the product
	 */
	public void setProduct(final SessionContext ctx, final Product value)
	{
		PRODUCTHANDLER.addValue( ctx, value, this  );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Question.product</code> attribute. 
	 * @param value the product
	 */
	public void setProduct(final Product value)
	{
		setProduct( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Question.question</code> attribute.
	 * @return the question
	 */
	public String getQuestion(final SessionContext ctx)
	{
		return (String)getProperty( ctx, QUESTION);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Question.question</code> attribute.
	 * @return the question
	 */
	public String getQuestion()
	{
		return getQuestion( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Question.question</code> attribute. 
	 * @param value the question
	 */
	public void setQuestion(final SessionContext ctx, final String value)
	{
		setProperty(ctx, QUESTION,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Question.question</code> attribute. 
	 * @param value the question
	 */
	public void setQuestion(final String value)
	{
		setQuestion( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Question.questionCustomer</code> attribute.
	 * @return the questionCustomer
	 */
	public Customer getQuestionCustomer(final SessionContext ctx)
	{
		return (Customer)getProperty( ctx, QUESTIONCUSTOMER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Question.questionCustomer</code> attribute.
	 * @return the questionCustomer
	 */
	public Customer getQuestionCustomer()
	{
		return getQuestionCustomer( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Question.questionCustomer</code> attribute. 
	 * @param value the questionCustomer
	 */
	public void setQuestionCustomer(final SessionContext ctx, final Customer value)
	{
		setProperty(ctx, QUESTIONCUSTOMER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Question.questionCustomer</code> attribute. 
	 * @param value the questionCustomer
	 */
	public void setQuestionCustomer(final Customer value)
	{
		setQuestionCustomer( getSession().getSessionContext(), value );
	}
	
}
