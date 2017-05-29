from twilio.twiml.voice_response import Gather, VoiceResponse, Say

response = VoiceResponse()
gather = Gather(input='speech dtmf', num_digits=1, timeout=3)
gather.say('Please press 1 or say sales for sales.')
response.append(gather)

print(response)
